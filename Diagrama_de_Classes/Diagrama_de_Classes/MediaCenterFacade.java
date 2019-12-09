package Diagrama_de_Classes;

import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.*;
import java.util.*;

public class MediaCenterFacade {

	public static final String uploadsPath = "C:\\Users\\pedro\\Documents\\MediaCenterUNI";
	public static final String vlcPath = "D:\\VLC\\vlc.exe";

	private static SGContas contas;
	private static SGCol sgcol;

	public static void main(String[] arg){
		MediaCenterFacade m = new MediaCenterFacade();
		contas = new SGContas();
		sgcol = new SGCol();
		ContaDAO teste = ContaDAO.getInstance();
		ColecaoDAO testeCol = ColecaoDAO.getInstance();

		System.out.println(testeCol.get("Tonecas").get(0).toString());


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
	public boolean registarConta(String username, String password, String email) {
		try{
			contas.registarConta(username,password,email,false);
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
		// TODO Jorge jaz que eu não faço a minima do que tu pretendes fazer aqui...
		throw new UnsupportedOperationException();
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
	 * 
	 * @param diretorio
	 */
	public boolean upload(int id, String titulo, int tempo, Set<String> genero, String diretorio, boolean isPublic, String uploader) {
		try{
			Media m = new Media(id,titulo,tempo,genero,diretorio,isPublic,uploader);
			sgcol.addMediaColTemp(id,m);
			byte[] bytes = Files.readAllBytes(Paths.get(m.getDiretorio()));
			Path newPath = Paths.get(uploadsPath+id+titulo);
			Files.write(newPath,bytes);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/**
	 * 
	 * @param media
	 */
	public boolean download(Media media, String localGuardar) {
		try{
			byte[] bytes = Files.readAllBytes(Paths.get(media.getDiretorio()));
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
		sgcol.removeMediaFromCol(id);
		return true;
	}

	/**
	 * 
	 * @param media
	 */
	public void reproduzir(Media media) {
		try{

			ProcessBuilder pb = new ProcessBuilder(vlcPath, media.getDiretorio());

			Process start = pb.start();
		}catch(Exception e){
			return;
		}
	}

	/**
	 * 
	 * @param id
	 * @param colecao
	 */
	public void reproduzirFrom(int id, List<Media> colecao) {
		reproduzir(colecao.get(id));
	}

	/**
	 * 
	 * @param c
	 */
	public void reproduzirRandom(List<Media> c) {
		Random r = new Random();
		reproduzir(c.get(r.nextInt(c.size())));
	}

	/**
	 * 
	 * @param id
	 * @param titulo
	 * @param ismus
	 */
	public boolean criarColecao(int id, String criador, String titulo, boolean ispub, boolean ismus) {
		sgcol.addColecao(id,criador,titulo,ispub,ismus);
		return true;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean adicionarMediaColecao(int id,Media m) {
		sgcol.addMediaColTemp(id,m);
		return true;
	}

	/**
	 * 
	 * @param tipo
	 */
	public List<Media> getMedia(String tipo) {
		return sgcol.getMediaByType(tipo);
	}

	/**
	 * 
	 * @param classificacao
	 * @param col
	 */
	public boolean calssificarColecao(String username, String classificacao, int col) {
		sgcol.alterarCategoria(username, col, classificacao);
		return true;

	}

	/**
	 * 
	 * @param id
	 */
	public boolean apagarColecao(int id) {
		sgcol.removeColecao(id,contas.getContaTemp().getUsername());
		return true;
	}

	public List<Integer> getCollectionsUser() {
		return contas.getContaTemp().getColecoes();
	}

	/**
	 * 
	 * @param id
	 */
	public Colecao getColecao(String username, int id) {
		return sgcol.getColecao(username, id);
	}

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

}