package Diagrama_de_Classes;

import java.util.*;
import java.util.stream.Collectors;

public class SGCol {

	private ColecaoDAO colecoes;
	private Colecao colecaoTemp;
	private MediaDAO medias;

	public SGCol(){
		colecoes = ColecaoDAO.getInstance();
		medias = MediaDAO.getInstance();
	}

	/**
	 *
	 * @param id
	 * @param colecao
	 */
	public void addColecao(int id, Colecao colecao) {
		colecoes.put(id,colecao);
	}

	/**
	 * 
	 * @param idColection
	 */
	public void removeColecao(int idColection) {
		colecoes.remove(idColection);
	}

	//empty
	public Colecao criarColecao(int id, String titulo, String criador, String categoria, boolean isPublic){
		return new Colecao(id,titulo,criador,categoria,isPublic);
	}
	//recebe medias
	public Colecao criarColecao(int id, String titulo, String criador, String categoria, boolean isPublic, List<Integer> novasMedias){
		return new Colecao(id,titulo,criador,categoria,isPublic,novasMedias);
	}

	public List<Media> getMediaByType(String type){
		if(type.toLowerCase().equals("video")) return medias.values().stream().filter(m -> m instanceof Video).collect(Collectors.toList());
		else return medias.values().stream().filter(m -> m instanceof Musica).collect(Collectors.toList());
	}

	public Colecao getColecaoTemp() {
		return this.colecaoTemp;
	}

	/**
	 * 
	 * @param colecaoTemp
	 */
	public void setColecaoTemp(Colecao colecaoTemp) {
		this.colecaoTemp = colecaoTemp;
	}


	public List<Media> getMediaColecao(int id) {
		return new ArrayList<Media>(colecoes.get(id).getMedias());
		// SE FOR A DA TEMPORARIA // return new ArrayList<>(this.colecaoTemp.getMedias().values());
	}

	/**
	 * @param novaMedia
	 */
	public void addMediaColTemp(Media novaMedia) {
		this.colecaoTemp.getMedias().add(novaMedia);
	}

	/**
	 * 
	 * @param idMedia
	 */
	public void removeMediaFromCol(int idMedia) {
		this.colecaoTemp.getMedias().remove(idMedia);
	}


	/**
	 * 
	 * @param idCol
	 * @param categoria
	 */
	public boolean alterarCategoria(int idCol, String categoria) {
		colecoes.get(idCol).setCategoria(categoria);
		return true;
	}

	/**
	 * 
	 * @param id
	 */
	public Colecao getColecao(int id) {
		return colecoes.get(id);
	}

}