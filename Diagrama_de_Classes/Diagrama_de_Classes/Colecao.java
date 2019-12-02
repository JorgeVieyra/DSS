package Diagrama_de_Classes;

import java.util.*;

public class Colecao {

	private int ID;
	private String Titulo;
	private List<String> CollectionIDs;
	private String Criador;
	private String Categoria;
	private Collection<Integer> Tamanho;
	private boolean isPublic;
	private boolean isMusic;

	public String getTitulo() {
		// TODO - implement Coleção.getTitulo
		throw new UnsupportedOperationException();
	}

	public Conta getCriador() {
		// TODO - implement Coleção.getCriador
		throw new UnsupportedOperationException();
	}

	public String getCategoria() {
		// TODO - implement Coleção.getCategoria
		throw new UnsupportedOperationException();
	}

	public int getTamanho() {
		// TODO - implement Coleção.getTamanho
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param t
	 */
	public void setTitulo(String t) {
		// TODO - implement Coleção.setTitulo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param c
	 */
	public void setCategoria(String c) {
		// TODO - implement Coleção.setCategoria
		throw new UnsupportedOperationException();
	}

	public Integer getID() {
		// TODO - implement Coleção.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Coleção.setID
		throw new UnsupportedOperationException();
	}

	public boolean getIsPrivate() {
		// TODO - implement Coleção.getIsPrivate
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param isPrivate
	 */
	public void setIsPrivate(boolean isPrivate) {
		// TODO - implement Coleção.setIsPrivate
		throw new UnsupportedOperationException();
	}

	public List<String> getCollectionIDs() {
		// TODO - implement Coleção.getCollectionIDs
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param CollectionIDs
	 */
	public void setCollectionIDs(List<String> CollectionIDs) {
		// TODO - implement Coleção.setCollectionIDs
		throw new UnsupportedOperationException();
	}

	public List<String> getInfo() {
		// TODO - implement Coleção.getInfo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean removeIDMedia(int id) {
		// TODO - implement Coleção.removeIDMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param titulo
	 * @param criador
	 * @param isPublic
	 * @param isMusic
	 */
	public Colecao(String titulo, String criador, boolean isPublic, boolean isMusic) {
		// TODO - implement Coleção.Colecão
		throw new UnsupportedOperationException();
	}

	public boolean getIsMusic() {
		return this.isMusic;
	}

	/**
	 * 
	 * @param isMusic
	 */
	public void setIsMusic(boolean isMusic) {
		this.isMusic = isMusic;
	}

	public Colecao Clone() throws CloneNotSupportedException {
		return null;
	}
}