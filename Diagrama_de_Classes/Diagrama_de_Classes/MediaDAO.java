package Diagrama_de_Classes;

import java.util.List;
import java.util.Map;

public class MediaDAO {

	private Map<String, Musica> Musicas;
	private Map<String, Video> Videos;
	private List<Media> MediaTemp;

	/**
	 * 
	 * @param id
	 */
	public boolean removeMedia(String id) {
		// TODO - implement SGMedia.removeMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param m
	 */
	public void addMedia(Media m) {
		// TODO - implement SGMedia.addMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tipo
	 * @param uploader
	 */
	public List<Media> getMediaUser(String tipo, String uploader) {
		// TODO - implement SGMedia.getMediaUser
		throw new UnsupportedOperationException();
	}

	public List<Media> getMediaTemp() {
		// TODO - implement SGMedia.getMediaTemp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param MediaTemp
	 */
	public void setMediaTemp(List<Media> MediaTemp) {
		// TODO - implement SGMedia.setMediaTemp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param listaMedia
	 */
	public List<List<String>> getInfoMediaUser(List<Media> listaMedia) {
		// TODO - implement SGMedia.getInfoMediaUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param titulo
	 * @param tempo
	 * @param genero
	 * @param diretorio
	 * @param isPublic
	 * @param uploader
	 */
	public boolean addNewMedia(String titulo, int tempo, String genero, String diretorio, boolean isPublic, String uploader) {
		// TODO - implement SGMedia.addNewMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uploader
	 */
	public boolean removePrivateMedia(String uploader) {
		// TODO - implement SGMedia.removePrivateMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ids
	 */
	public List<Musica> getMusicas(List<String> ids) {
		// TODO - implement SGMedia.getMusicas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ids
	 */
	public List<Video> getVideos(List<String> ids) {
		// TODO - implement SGMedia.getVideos
		throw new UnsupportedOperationException();
	}

}