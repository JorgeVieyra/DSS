package Diagrama_de_Classes;

import java.util.*;

public class Colecao {

	private int id;
	private String titulo;
	private List<String> collectionIDs;
	private String criador;
	private String categoria;
	private boolean isPublic;
	private boolean isMusic;

	public int getID() {
		return id;
	}

	public void setID(int ID) {
		this.id = ID;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String title) {
		titulo = title;
	}

	public List<String> getCollectionIDs() {
		List res = new ArrayList<String>();
		for (String s : this.collectionIDs) {
			res.add(s);
		}
		return res;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String creator) {
		criador = creator;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String category) {
		categoria = category;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean aPublic) {
		isPublic = aPublic;
	}

	public boolean isMusic() {
		return isMusic;
	}

	public void setMusic(boolean music) {
		isMusic = music;
	}

	public Colecao(int id, String t, String c, boolean ispub, boolean ismus) {
		this.id = id;
		this.titulo = t;
		this.collectionIDs = new ArrayList<String>();
		this.criador = c;
		this.categoria = "N/A";
		this.isPublic = ispub;
		this.isMusic = ismus;
	}

	public boolean getIsMusic() {
		return this.isMusic;
	}

	public void setIsMusic(boolean isMusic) {
		this.isMusic = isMusic;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Colecao colecao = (Colecao) o;
		return id == colecao.id &&
				isPublic == colecao.isPublic &&
				isMusic == colecao.isMusic &&
				Objects.equals(titulo, colecao.titulo) &&
				Objects.equals(collectionIDs, colecao.collectionIDs) &&
				Objects.equals(criador, colecao.criador) &&
				Objects.equals(categoria, colecao.categoria);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo, collectionIDs, criador, categoria, isPublic, isMusic);
	}
}
