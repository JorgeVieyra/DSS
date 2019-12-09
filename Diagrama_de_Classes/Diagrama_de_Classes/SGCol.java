package Diagrama_de_Classes;

import java.util.*;
import java.util.stream.Collectors;

public class SGCol {

	private ColecaoDAO colecoes;
	private Colecao colecaoTemp;

	/**
	 * 
	 * @param titulo
	 * @param isPublic
	 * @param isMusic
	 */
	public void addColecao(int id, String username, String titulo, boolean isPublic, boolean isMusic) {
		if(colecoes.containsKey(username)){
			List<Colecao> novaColecao = new ArrayList<Colecao>();
			novaColecao.add(new Colecao(colecoes.get(username).size(),username,titulo,isPublic,isMusic));
			colecoes.put(username,novaColecao);

		}else{
			List<Colecao> novaColecao = new ArrayList<Colecao>();
			novaColecao.add(new Colecao(1,username,titulo,isPublic,isMusic));
			colecoes.put(username,novaColecao);
		}
	}

	/**
	 * 
	 * @param idColection
	 * @param username
	 */
	public void removeColecao(int idColection, String username) {
		List<Colecao> newList = new ArrayList<Colecao>();
		newList = this.colecoes.get(username);
		newList.remove(idColection);
		this.colecoes.put(username,newList);
	}

	public List<Media> getMediaByType(String type){
		return colecaoTemp.getMedias().values().stream().filter(m -> m.getGenero().equals(type)).collect(Collectors.toList());
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

	/**
	 *
	 * @param username
	 */
	public List<Media> getMediaColecao(int id, String username) {
		return new ArrayList<>(colecoes.get(username).get(id).getMedias().values());
		// SE FOR A DA TEMPORARIA // return new ArrayList<>(this.colecaoTemp.getMedias().values());
	}

	/**
	 * 
	 * @param id
	 * @param novaMedia
	 */
	public void addMediaColTemp(int id, Media novaMedia) {
		this.colecaoTemp.getMedias().put(id,novaMedia);
	}

	/**
	 * 
	 * @param idMedia
	 */
	public void removeMediaFromCol(int idMedia) {
		this.colecaoTemp.getMedias().remove(idMedia);
	}

	public List<Colecao> getColecoes(String username) {
		return this.colecoes.get(username);
	}

	/**
	 * 
	 * @param cols
	 */
	public List<String> getTitulosCategorias(String username, List<Integer> cols) {
		List<String> m = new ArrayList<>();
		for(int i = 0; i < cols.size(); i++){
			m.add(colecoes.get(username).get(cols.get(0)).getTitulo());
		}
		return m;
	}

	/**
	 * 
	 * @param idCol
	 * @param categoria
	 */
	public boolean alterarCategoria(String username, int idCol, String categoria) {
		colecoes.get(username).get(idCol).setCategoria(categoria);
		return true;
	}

	/**
	 * 
	 * @param id
	 */
	public Colecao getColecao(String username, int id) {
		return colecoes.get(username).get(id);
	}

}