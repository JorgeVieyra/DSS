package Diagrama_de_Classes;

import java.util.*;

public class Colecao {

	private int id;
	private String titulo;
	private MediaDAO medias;
	private String criador;
	private String categoria;
	private boolean isPublic;
	private boolean isMusic;

	public int getID(){
		return this.id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String title) {
		titulo = title;
	}

	public Set<Integer> getIds() {
		return medias.keySet();
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

	public Colecao(int id, String criador, String titulo, boolean ispub, boolean ismus) {
		this.id = id;
		this.titulo = titulo;
		this.medias = MediaDAO.getInstance();
		this.criador = criador;
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

	public MediaDAO getMedias(){
		return this.medias;
	}
	public void setMedias(MediaDAO medias){
		this.medias = medias;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Colecao colecao = (Colecao) o;
		return isPublic == colecao.isPublic &&
				isMusic == colecao.isMusic &&
				Objects.equals(titulo, colecao.titulo) &&
				Objects.equals(medias, colecao.medias) &&
				Objects.equals(criador, colecao.criador) &&
				Objects.equals(categoria, colecao.categoria);
	}

}
