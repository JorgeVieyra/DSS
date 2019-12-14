package Diagrama_de_Classes;

import java.util.*;
import java.util.stream.Collectors;

public class Colecao {

	private int id;
	private String titulo;
	private List<Integer> mediasIDs;
	private MediaDAO medias;
	private String criador;
	private String categoria;
	private boolean isPublic;

//region getters e setter

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

	public Boolean getisPublic() { return isPublic;}

	public void setCategoria(String category) {
		categoria = category;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean aPublic) {
		isPublic = aPublic;
	}

	//endregion


	public Colecao(int id, String criador, String titulo, String categoria, boolean ispub) {
		this.id = id;
		this.titulo = titulo;
		this.mediasIDs = new ArrayList<>();
		this.medias = MediaDAO.getInstance();
		this.criador = criador;
		this.categoria = categoria;
		this.isPublic = ispub;
	}

	public Colecao(int id, String criador, String titulo, String categoria, boolean ispub, List<Integer> mediasNovas) {
		this.id = id;
		this.titulo = titulo;
		this.mediasIDs = mediasNovas;
		this.medias = MediaDAO.getInstance();
		this.criador = criador;
		this.categoria = categoria;
		this.isPublic = ispub;
	}

	public List<Media> getMedias(){
		List<Media> m = new ArrayList<Media>();
		for (Integer id : mediasIDs) {
			m.add(medias.get(id));
		}
		return m;
	}
	public void setMedias(List<Media> medias){
		this.mediasIDs = medias.stream().map(Media::getID).collect(Collectors.toList());
	}

	public List<Integer> getMediasIDs() {
		return mediasIDs;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Colecao colecao = (Colecao) o;
		return isPublic == colecao.isPublic &&
				Objects.equals(titulo, colecao.titulo) &&
				Objects.equals(medias, colecao.medias) &&
				Objects.equals(criador, colecao.criador) &&
				Objects.equals(categoria, colecao.categoria);
	}

	@Override
	public String toString() {
		return "Colecao{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", mediasIDs=" + mediasIDs +
				", medias=" + medias +
				", criador='" + criador + '\'' +
				", categoria='" + categoria + '\'' +
				", isPublic=" + isPublic +
				'}';
	}
}
