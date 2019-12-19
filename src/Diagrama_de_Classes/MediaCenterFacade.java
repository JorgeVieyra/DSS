package Diagrama_de_Classes;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import static java.nio.file.StandardCopyOption.*;

public class MediaCenterFacade {


	private static SGContas contas;
	private static SGCol sgcol;

	private static MediaCenterFacade inst = null;

	private MediaCenterFacade(){
		contas = new SGContas();
		sgcol = new SGCol();
	}


	public static MediaCenterFacade getInstance(){
		if (inst == null) {
			inst = new MediaCenterFacade();
		}
		return inst;
	}

	public static void main(String[] args) {

	}

	public void updateTemp(){
		contas.updateContaTemp();
	}
	/**
	 *
	 * @param username
	 * @param password
	 */
	public boolean login(String username, String password) {
		try{
			contas.login(username,password);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public boolean contaIsAdmin(){
		return contas.getContaTemp() instanceof Conta_Admin;
	}

	/**
	 *
	 * @param username
	 */
	public boolean logout(String username) {
		try{
			contas.logout();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 *
	 * @param username
	 * @param password
	 * @param email
	 */
	public boolean registarConta(String username, String password, String email, boolean isAdmin) {
		try{
			contas.registarConta(username,password,email,isAdmin);
			return true;
		}catch (Exception e){
			return false;
		}
	}

	/**
	 *
	 * @param username
	 * @param atributo
	 * @param isPassword
	 */
	public boolean editarConta(String username, String atributo, boolean isPassword) {
		try {
			if (isPassword) contas.alterarPassword(atributo, username);
			else contas.alterarEmail(atributo, username);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 *
	 * @param username
	 */
	public boolean eliminarConta(String username) {
		try{
			contas.apagarConta(username);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 *
	 * @param username
	 */
	public boolean adicionarAmigo(String username) {
		try {
			contas.adicionarAmigo(username);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	public void transferenciaMedia(String in, String out) throws IOException {	Files.copy(Paths.get(in), Paths.get(out), StandardCopyOption.REPLACE_EXISTING);}

	/**
	 *
	 * @param media
	 */
	public boolean download(Media media, String localGuardar) {
		try{
			//TODO WHY THIS NOT WORK?
			byte[] bytes = Files.readAllBytes(Paths.get("C:/Users/pedro/Desktop/Ricardo Milos Party.mp4"));
			Path newPath = Paths.get(localGuardar);
			Files.write(newPath,bytes);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 *
	 * @param id
	 */
	public boolean apagarMedia(int id) throws IOException {
		//TODO FIX
		sgcol.removeMedia(id);
		return true;
	}

	/**
	 *
	 * @param diretorio
	 */
	public void reproduzir(List<String> diretorio) {
		//TODO FIX
		try{
			List<String> command = new ArrayList<>();
			command.add(Files.readAllLines(Paths.get("VLCPath")).get(0));command.add("--started-from-file");command.add("--playlist-enqueue");
			for(String s : diretorio) command.add(String.format("\"%s\"",s));
			ProcessBuilder pb = new ProcessBuilder(command);
			System.out.println(String.join(" ",command));
			Process start = pb.start();
		}catch(Exception e){
			return;
		}
	}

	public void reproduzir(String diretorio) {
		//TODO FIX
		try{
			List<String> command = new ArrayList<>();
			command.add(Files.readAllLines(Paths.get("VLCPath")).get(0));command.add("--started-from-file");command.add("--playlist-enqueue");
			command.add(diretorio);
			ProcessBuilder pb = new ProcessBuilder(command);

			Process start = pb.start();
		}catch(Exception e){
			return;
		}
	}

	public Conta getTemp() { return contas.getContaTemp();}


	/**
	 *
	 * @param id
	 * @param colecao
	 */

	/**
	 *
	 * @param id
	 * @param titulo
	 */
	public boolean criarColecao(int id, String criador, String titulo, String categoria, boolean ispub) {
		sgcol.addColecao(id,new Colecao(id,criador,titulo,categoria,ispub));
		return true;
	}

	public boolean updateColecao(Colecao col) {
		sgcol.addColecao(col.getID(),col);
		return true;
	}

	/**
	 *
	 * @param mediaID, colID
	 * @return
	 */
	public boolean adicionarMediaColecao(Integer mediaID, Integer colID) {
		sgcol.addToCol(mediaID,colID);
		return true;
	}

	/**
	 *
	 * @param tipo
	 */
	public List<Media> getMedia(String tipo) {
		return sgcol.getMediaByType(tipo);
	}

	public List<Media> getMedia() {
		return sgcol.getAllMedia();
	}

	/**
	 *
	 * @param classificacao
	 * @param col
	 */
	public boolean calssificarColecao(String classificacao, int col) {
		sgcol.alterarCategoria(col, classificacao);
		return true;

	}

	/**
	 *
	 * @param id
	 */
	public boolean apagarColecao(int id) {
		sgcol.removeColecao(id);
		return true;
	}

	public List<Integer> getCollectionIDsUser() {
		return contas.getContaTemp().getColecoes();
	}

	public List<Colecao> getCollectionUser(){
		List userCols = new ArrayList<Colecao>();
		for(Integer id : this.getCollectionIDsUser())
			userCols.add(sgcol.getColecao(id));
		return userCols;
	}

	/**
	 *
	 * @param id
	 */
	public Colecao getColecao(int id) {
		return sgcol.getColecao(id);
	}

	public List<Media>Availiablemedia() {return sgcol.getAvailiableMedia(contas.getContaTemp().getUsername());}

	/**
	 *
	 * @param username
	 * @param pass
	 */
	public boolean verificaPassword(String username, String pass) {
		try{
			return contas.getConta(username).getPassword().equals(pass);
		}catch (Exception e){
			return false;
		}
	}

	public boolean loginConvidado() {
		return true;
	}

	public boolean logoutConvidado() {
		return true;
	}

	/**
	 *
	 * @param diretorio
	 */

	public javafx.util.Duration checkTempoMedia(String diretorio) {
		//TODO FIX
		try {
			File filestring = new File(diretorio);
			javafx.scene.media.Media file = new javafx.scene.media.Media (filestring.toURI().toString());
			com.sun.javafx.application.PlatformImpl.startup(()->{});
			MediaPlayer mediaPlayer = new MediaPlayer(file);

			while (file.getDuration().toString().equalsIgnoreCase("UNKNOWN")) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException ex) {
				}
			}

			return file.getDuration();

		}catch(Exception e){
			return Duration.UNKNOWN;
		}
	}

	/**
	 *
	 * @param location
	 */
	public String checkTituloMedia(String location) {
		File f = new File(location);
		if(f.exists()){
			return f.getName();
		}else{
			return "Invalid File Path";
		}
	}

	/**
	 *
	 * @param username
	 */
	public boolean verificaUsername(String username) {
		return contas.usernameExiste(username);
	}

	public int findColFreeID() {return sgcol.getFirstAvailiableID();}

	public List<Colecao> getPublicCol(){return sgcol.PublicCols();}

	public List<Media> getMediaOfTemp(){return sgcol.getMediaOfUser(contas.getContaTemp().getUsername());}

	public Collection<Conta> getContas(){return contas.getContas();}

	public List<String> getNonFriends(){return contas.getNonFriends();}

	public void addAmizade(String username1,String username2){contas.addFriend(username1,username2);}

	public void remAmizade(String username1,String username2){contas.remFriend(username1,username2);}

	public void removeRelationship(Integer mediaID, Integer colID){sgcol.removeRelationship(mediaID,colID);}

	public void apagarConta(String username) throws InvalidUsernameException {contas.apagarConta(username);}

	public void addMediaToDB(String uploader,String titulo,String artista,String caminho,Boolean isPublic,Boolean isVideo){sgcol.addMediaToDB(uploader,titulo,artista,caminho,isPublic,isVideo);}
}