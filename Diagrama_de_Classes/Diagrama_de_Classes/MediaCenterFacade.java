package Diagrama_de_Classes;

import java.util.List;

public class MediaCenterFacade {

	private SGContas SGContas;
	private SGCol SGCol;
	private MediaDAO SGMedia;

	public static void main(String[] arg){
		System.out.println("I'm Alive.");
		ContaDAO contas = ContaDAO.getInstance();
		MediaDAO media = MediaDAO.getInstance();
		System.out.println(contas.get("Tonecas").toString());

		/* Swing
		Menu m = new Menu(new String[]{"a","b","c"},1280,720);
		m.startMenu();
		*/
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public boolean login(String username, String password) {
		// TODO - implement Media_Center_Facade.login
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 */
	public boolean logout(String username) {
		// TODO - implement Media_Center_Facade.logout
		throw new UnsupportedOperationException();
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
		// TODO - implement Media_Center_Facade.eliminarConta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean adicionarAmigo(int id) {
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
	public int checkTempoMedia(String diretorio) {
		// TODO - implement Media_Center_Facade.checkTempoMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param diretorio
	 */
	public String checkTituloMedia(String diretorio) {
		// TODO - implement Media_Center_Facade.checkTituloMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 */
	public boolean verificaUsername(String username) {
		// TODO - implement Media_Center_Facade.verificaUsername
		throw new UnsupportedOperationException();
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