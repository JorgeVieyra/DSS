package Diagrama_de_Classes;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.*;
import java.util.*;

public class MediaCenterFacade {

	public static final String uploadsPath = "C:\\Users\\pedro\\Documents\\MediaCenterUNI";
	public static final String vlcPath = "/Applications/VLC.app/Contents/MacOS/VLC";

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
			System.out.println(e.getMessage());
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

	/**
	 *  Upload de uma media atraves de uma media ainda não criada
	 * @param id ...
	 * @param titulo ...
	 * @param diretorio ...
	 * @param isPublic ...
	 * @param uploader ...
	 * @return ...
	 */
	public boolean upload(int id, String titulo, String diretorio, boolean isPublic, String uploader) {
		try{
			Media m = new Media(id,titulo,-1,null,diretorio,isPublic,uploader);
			sgcol.addMediaColTemp(m);
			byte[] bytes = Files.readAllBytes(Paths.get(m.getDiretorio()));
			Path newPath = Paths.get(uploadsPath+id+titulo);
			Files.write(newPath,bytes);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * Upload de media atraves de uma media já existente
	 * @param m ...
	 * @return ...
	 */
	public boolean upload(Media m){
		try{
			byte[] bytes = Files.readAllBytes(Paths.get(m.getDiretorio()));
			Path newPath = Paths.get(uploadsPath+m.getID()+m.getTitulo());
			Files.write(newPath,bytes);
			return true;
		}catch (Exception e){
			return false;
		}
	}

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
	public boolean apagarMedia(int id) {
		//TODO FIX
		sgcol.removeMedia(id);
		return true;
	}

	/**
	 *
	 * @param media
	 */
	public void reproduzir(Media media) {
		//TODO FIX
		try{

			ProcessBuilder pb = new ProcessBuilder(vlcPath, media.getDiretorio());

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
	public void reproduzirFrom(int id, List<Media> colecao) {
		//TODO FIX
		reproduzir(colecao.get(id));
	}

	/**
	 *
	 * @param c
	 */
	public void reproduzirRandom(List<Media> c) {
		//TODO FIX
		Random r = new Random();
		reproduzir(c.get(r.nextInt(c.size())));
	}

	/**
	 *
	 * @param id
	 * @param titulo
	 */
	public boolean criarColecao(int id, String criador, String titulo, String categoria, boolean ispub) {
		sgcol.addColecao(id,new Colecao(id,criador,titulo,categoria,ispub));
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

	public String checkType(String location){
		List<String> AudioExtensions = new ArrayList<>(Arrays.asList(".mp3"));
		return "yes";
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
}