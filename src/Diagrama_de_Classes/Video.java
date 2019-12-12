package Diagrama_de_Classes;

import javafx.util.Pair;

import java.util.Set;

public class Video extends Media {

	private Pair<Integer,Integer> resolucao;
	private int framerate;

	/**
	 * @param titulo titulo super
	 * @param tempo tempo super
	 * @param genero genero super
	 * @param diretorio diretorio super
	 * @param isPublic isPublic super
	 * @param uploader uploader super
	 */
	public Video(int id, String titulo, int tempo, Set<String> genero, String diretorio, boolean isPublic, String uploader, Pair<Integer, Integer> resolucao, int framerate) {
        super(id,titulo,tempo,genero,diretorio,isPublic,uploader);
        this.resolucao = resolucao;
        this.framerate = framerate;
	}

	public Pair<Integer,Integer> getResolucao() {
	    return this.resolucao;
	}

	public int getFramerate() {
	    return this.framerate;
	}

}