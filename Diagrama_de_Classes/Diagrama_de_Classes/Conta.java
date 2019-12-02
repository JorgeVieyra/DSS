package Diagrama_de_Classes;

import java.util.*;

public class Conta {

	private String username;
	private String email;
	private String password;
	private List<Integer> colecoes;
	private List<String> listaAmigos;
	private boolean loggedIn;

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.username;
	}

	public List<Integer> getColecoes() {
		List<Integer> newList = new ArrayList<Integer>();
		for(int i = 0; i < colecoes.size(); i++){
			newList.add(colecoes.get(i));
		}
		return newList;
	}

	public List<String> getListaAmigos() {
		List<String> newList = new ArrayList<String>();
		for(int i = 0; i < listaAmigos.size(); i++){
			newList.add(listaAmigos.get(i));
		}
		return newList;
	}

	/**
	 * 
	 * @param username
	 */
	public void addAmigo(String username) {
		if(!listaAmigos.contains(username)) listaAmigos.add(username);
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @param colecoes
	 */
	public void setColecoes(List<Colecao> colecoes){
		List<Integer> list = new ArrayList<>();
		for (Colecao c : colecoes) {
			c.getID();
		}
		this.colecoes = list;
	}

	/**
	 * 
	 * @param listaAmigos
	 */
	public void setListaAmigos(List<String> listaAmigos) {
		this.listaAmigos = listaAmigos;
	}

	/**
	 * 
	 * @param email
	 * @param password
	 * @param username
	 */
	public Conta(String email, String password, String username) {
		this.email = email;
		this.password = password;
		this.username = username;
	}

	public boolean getLoggedIn() {
		return this.loggedIn;
	}

	/**
	 * 
	 * @param loggedIn
	 */
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}