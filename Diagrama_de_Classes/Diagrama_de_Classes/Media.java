package Diagrama_de_Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class Media {

	private int id;
	private String titulo;
	private int tempo;
	private Set<String> genero;
	private LocalDate addDate;
	private double tamanhoBytes;
	private String diretorio;
	private boolean isPublic;
	private String uploader;

	/**
	 * @param titulo Titulo da media
	 * @param tempo Tempo da media
	 * @param genero Generos
	 * @param diretorio localizacao do ficheiro
	 * @param isPublic partilhado entre utilizadores ou privado
	 * @param uploader utilizador que deu upload do ficheiro
	 */
	public Media(int id, String titulo, int tempo, Set<String> genero, String diretorio, boolean isPublic, String uploader) {
		this.id = id;
		try{ this.tamanhoBytes = this.getFile(diretorio).length();} catch (FileNotFoundException e) {this.tamanhoBytes = -1;}
		this.addDate = LocalDate.now();
		this.titulo = titulo;
		this.genero = genero;
		this.diretorio = diretorio;
		this.isPublic = isPublic;
		this.uploader = uploader;
	}
	public String getTitulo() {
		return this.titulo;
	}

	public int getTempo() {
		return this.tempo;
	}

	public Set<String> getGenero() {
		return this.genero;
	}

	public LocalDate getAddDate() {
		return this.addDate;
	}

	public double getTamanho() {
		return this.tamanhoBytes;
	}

	public int getID() {
		return this.id;
	}

	public String getDiretorio() {
		return this.diretorio;
	}

	public boolean getIsPublic() {
		return this.isPublic;
	}

	public String getUploader() {
		return this.uploader;
	}

	public File getFile(String diretorio) throws FileNotFoundException {
		File file = new File(diretorio);
		if (file.exists() && file.isFile()){
			return file;
		}else{
			throw new FileNotFoundException("Erro: Ficheiro não existe!");
		}
	}


	/**
	 * 
	 * @param g generos novos
	 */
	public void setGenero(Set<String> g) {
		this.genero = new HashSet<>(g);
	}

	/**
	 * 
	 * @param tamanhoBytes tamanho do ficheiro
	 */
	public void setTamanhoBytes(double tamanhoBytes) {
		this.tamanhoBytes = tamanhoBytes;
	}

	/**
	 * 
	 * @param titulo titulo do ficheiro
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * 
	 * @param tempo duracao do ficheiro
	 */
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	/**
	 * 
	 * @param id identificador do ficheiro
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param diretorio localizaçao do ficheiro
	 */
	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}


	/**
	 * 
	 * @param isPublic partilhado entre utilizadores ou privado
	 */
	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	/**
	 * 
	 * @param uploader utiilizador que due upload do ficheiro
	 */
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

}