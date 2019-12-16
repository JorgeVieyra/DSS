package Diagrama_de_Classes;

import java.util.*;
import java.util.stream.Collectors;

public class SGCol {

	private ColecaoDAO colecoes;
	private Colecao colecaoTemp;
	private MediaDAO medias;

	public SGCol(){
		this.colecoes = ColecaoDAO.getInstance();
		this.medias = MediaDAO.getInstance();
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

	public List<Colecao> PublicCols(){
		return colecoes.getPublicCols();
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

	public void removeMedia(int idMedia){
		this.medias.remove(idMedia);
	}

	public List<Media> getAllMedia(){return medias.valuesList();}
	/**
	 * 
	 * @param idCol
	 * @param categoria
	 */
	public boolean alterarCategoria(int idCol, String categoria) {
		colecoes.get(idCol).setCategoria(categoria);
		return true;
	}

	public Integer getFirstAvailiableID(){
		Set<Integer> ids = colecoes.keySet();
		Integer i = 1;
		for(;ids.contains(i);i++);
		return i;
	}

	public Integer getFirstAvailiableRelID(){
		Set<Integer> ids = colecoes.keySetRel();
		Integer i = 1;
		for(;ids.contains(i);i++);
		return i;
	}

	public void addToCol(Integer media,Integer col){
		colecoes.addRelationship(getFirstAvailiableRelID(),media,col);
	}

	/**
	 * 
	 * @param id
	 */
	public Colecao getColecao(int id) {
		return colecoes.get(id);
	}

	public List<Media> getAvailiableMedia(String username){return medias.Availiablevalues(username);}

	public List<Media> getMediaOfUser(String username){return medias.getMediaOfUtilizador(username);}
}