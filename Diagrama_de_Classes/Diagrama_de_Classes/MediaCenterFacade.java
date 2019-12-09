package Diagrama_de_Classes;

import com.sun.media.sound.SF2GlobalRegion;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class MediaCenterFacade {

	private static SGContas contas;
	private static SGCol sgcol;

	public static void main(String[] arg){
		MediaCenterFacade m = new MediaCenterFacade();
		contas = new SGContas();
		sgcol = new SGCol();
		System.out.println(m.checkTempoMedia("C:\\Users\\pedro\\Videos\\2019-10-05 00-15-45.mkv"));
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
		// TODO - implement Media_Center_Facade.registarConta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 * @param atributo
	 * @param isPassword
	 */
	public boolean editarConta(String username, String atributo, boolean isPassword) {
		// TODO - implement Media_Center_Facade.editarConta
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
		// TODO - implement Media_Center_Facade.adicionarAmigo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param diretorio
	 * @param privacy
	 * @param genero
	 */
	public boolean upload(String diretorio, boolean privacy, String genero) {
		// TODO - implement Media_Center_Facade.upload
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param media
	 */
	public Media download(Media media) {
		// TODO - implement Media_Center_Facade.download
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean apagarMedia(String id) {
		// TODO - implement Media_Center_Facade.apagarMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public List<String> reproduzir(List<Media> c) {
		// TODO - implement Media_Center_Facade.reproduzir
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 * @param colecao
	 */
	public List<String> reproduzirFrom(int id, List<Media> colecao) {
		// TODO - implement Media_Center_Facade.reproduzirFrom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public List<String> reproduzirRandom(List<Media> c) {
		// TODO - implement Media_Center_Facade.reproduzirRandom
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nome
	 * @param creator
	 * @param tipo
	 */
	public boolean criarColecao(String nome, String creator, String tipo) {
		// TODO - implement Media_Center_Facade.criarColecao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean adicionarMediaColecao(String id) {
		// TODO - implement Media_Center_Facade.adicionarMediaColecao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tipo
	 */
	public List<String> getMedia(String tipo) {
		// TODO - implement Media_Center_Facade.getMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param calssificacao
	 * @param col
	 */
	public boolean calssificarColecao(String calssificacao, int col) {
		// TODO - implement Media_Center_Facade.calssificarCole�ao
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean apagarColecao(int id) {
		// TODO - implement Media_Center_Facade.apagarCole��o
		throw new UnsupportedOperationException();
	}

	public List<Integer> getCollectionsUser() {
		// TODO - implement Media_Center_Facade.getCollectionsUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public List<String> getColecao(int id) {
		// TODO - implement Media_Center_Facade.getCole��o
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pass
	 */
	public boolean verificaPassword(String pass) {
		// TODO - implement Media_Center_Facade.verificaPassword
		throw new UnsupportedOperationException();
	}

	public boolean loginConvidado() {
		// TODO - implement Media_Center_Facade.loginConvidado
		throw new UnsupportedOperationException();
	}

	public boolean logoutConvidado() {
		// TODO - implement Media_Center_Facade.logoutConvidado
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param diretorio
	 */
	public double checkTempoMedia(String diretorio) {
		try {
			File file = new File(diretorio);
			return file.length();/*
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
			AudioFormat format = audioInputStream.getFormat();
			long frames = audioInputStream.getFrameLength();
			return (frames+0.0) / format.getFrameRate();*/
		}catch(Exception e){
			e.printStackTrace();
			return -1;
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

	/**
	 * 
	 * @param media
	 */
	public List<String> Play(Media media) {
		// TODO - implement Media_Center_Facade.Play
		throw new UnsupportedOperationException();
	}

}