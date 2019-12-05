package Diagrama_de_Classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SGCol {

	//TODO verificar quando a colecaoTemp é null
	private ColecaoDAO colecoes;
	private Colecao colecaoTemp;

	/**
	 * 
	 * @param titulo
	 * @param criador
	 * @param isPublic
	 * @param isMusic
	 */
	public void addColecao(int id, String username, String titulo, String criador, boolean isPublic, boolean isMusic) {
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

	/**
	 * 
	 * @param criador
	 */
	public boolean removePrivateCol(String criador) {
		// TODO - implement SGCol.removePrivateCol
		throw new UnsupportedOperationException();
	}

	public List<Colecao> getColecoes() {
		// TODO - implement SGCol.getColecoes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param cols
	 */
	public Map<String, Integer> getTitulosCategorias(List<Integer> cols) {
		// TODO - implement SGCol.getTitulosCategorias
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idCol
	 * @param categoria
	 */
	public boolean alterarCategoria(int idCol, String categoria) {
		// TODO - implement SGCol.alterarCategoria
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public Colecao getColecao(int id) {
		// TODO - implement SGCol.getColecao
		throw new UnsupportedOperationException();
	}

	public void getCategorias() {
		// TODO - implement SGCol.getCategorias
		throw new UnsupportedOperationException();
	}

}