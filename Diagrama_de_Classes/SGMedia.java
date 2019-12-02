package Diagrama_de_Classes;

public class SGMedia {

	private Map<String, Musica> Musicas;
	private Map<String, Video> Videos;
	private List<Media> MediaTemp;

	/**
	 * 
	 * @param id
	 */
	public boolean removeMedia(string id) {
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
	public List<Media> getMediaUser(string tipo, string uploader) {
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
	public boolean addNewMedia(string titulo, int tempo, string genero, string diretorio, boolean isPublic, string uploader) {
		// TODO - implement SGMedia.addNewMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param uploader
	 */
	public boolean removePrivateMedia(string uploader) {
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