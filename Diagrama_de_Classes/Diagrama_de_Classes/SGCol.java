package Diagrama_de_Classes;

import java.util.List;
import java.util.Map;

public class SGCol {

	private ColecaoDAO Colecoes;
	private List<Media> ColecaoTemp;

	/**
	 * 
	 * @param titulo
	 * @param criador
	 * @param isPublic
	 * @param isMusic
	 */
	public void addColecao(String titulo, String criador, String isPublic, boolean isMusic) {
		// TODO - implement SGCol.addColeção
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param col
	 * @param user
	 */
	public boolean removeColecao(int col, String user) {
		// TODO - implement SGCol.removeColeção
		throw new UnsupportedOperationException();
	}

	public List<Media> getColecaoTemp() {
		// TODO - implement SGCol.getColeçãoTemp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ColeçãoTemp
	 */
	public void setColecaoTemp(List<Media> ColeçãoTemp) {
		// TODO - implement SGCol.setColeçãoTemp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public List<Media> getMediaColecao(int id) {
		// TODO - implement SGCol.getMediaColeção
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean addMediaColTemp(String id) {
		// TODO - implement SGCol.addMediaColTemp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param idMedia
	 */
	public boolean removeMediaFromCol(int idMedia) {
		// TODO - implement SGCol.removeMediaFromCol
		throw new UnsupportedOperationException();
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