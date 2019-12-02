package Diagrama_de_Classes;

import java.util.*;

public class Musica extends Media {

	private Collection<String> Artista;
	private int BitRate;

	/**
	 * @param Titulo
	 * @param Tempo
	 * @param genero
	 * @param diretorio
	 * @param isPublic
	 * @param uploader
	 */
	public Musica(String Titulo, int Tempo, String genero, int diretorio, boolean isPublic, String uploader) {
		super(Titulo, Tempo, genero, diretorio, isPublic, uploader);
	}

	public String getArtista() {
		// TODO - implement Musica.getArtista
		throw new UnsupportedOperationException();
	}

	public int getBitRate() {
		// TODO - implement Musica.getBitRate
		throw new UnsupportedOperationException();
	}

}