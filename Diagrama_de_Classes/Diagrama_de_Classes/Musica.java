package Diagrama_de_Classes;

import java.util.*;
import java.util.stream.Collectors;

public class Musica extends Media {

	private Collection<String> artistas;
	private int bitRate;

	/**
     * @param id id da super
	 * @param titulo titulo da super
     * @param artistas artistas da musica
	 * @param tempo tempo da super
	 * @param genero genero da super
	 * @param diretorio diretorio da super
	 * @param isPublic isPublic da super
	 * @param uploader uploader da super
	 */
	public Musica(int id, String titulo,Collection<String> artistas, int tempo, Set<String> genero, String diretorio, boolean isPublic, String uploader) {
		super(id,titulo,tempo,genero,diretorio,isPublic,uploader);
		this.artistas = artistas;
		this.bitRate = 128*1024; //Meio estranho ter a bitrate, mas por agora vamos deixar
	}

	public Collection<String> getArtista() {
	    return new ArrayList<>(this.artistas);
	}

	public int getBitRate() {
	    return this.bitRate;
	}

}