package Diagrama_de_Classes;

import java.util.List;

public class Video extends Media {

	private List<Integer> Resolucao;
	private int Framerate;

	/**
	 * @param Titulo
	 * @param Tempo
	 * @param genero
	 * @param diretorio
	 * @param isPublic
	 * @param uploader
	 */
	public Video(String Titulo, int Tempo, String genero, int diretorio, boolean isPublic, String uploader) {
		super(Titulo, Tempo, genero, diretorio, isPublic, uploader);
	}

	public List<Integer> getResolucao() {
		// TODO - implement Video.getResolução
		throw new UnsupportedOperationException();
	}

	public int getFramerate() {
		// TODO - implement Video.getFramerate
		throw new UnsupportedOperationException();
	}

}