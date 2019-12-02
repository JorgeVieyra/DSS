package Diagrama_de_Classes;

import java.time.LocalDate;
import java.util.*;

public class Media {

	private String ID;
	private String Titulo;
	private int Tempo;
	private Collection<String> Género;
	private LocalDate addDate;
	private double TamanhoBytes;
	private String Diretório;
	private boolean isPublic;
	private String uploader;

	public String getTitulo() {
		// TODO - implement Media.getTitulo
		throw new UnsupportedOperationException();
	}

	public LocalDate getTempo() {
		// TODO - implement Media.getTempo
		throw new UnsupportedOperationException();
	}

	public String getGenero() {
		// TODO - implement Media.getGenero
		throw new UnsupportedOperationException();
	}

	public LocalDate getAddDate() {
		return this.addDate;
	}

	/**
	 * 
	 * @param g
	 */
	public void setGenero(String g) {
		// TODO - implement Media.setGenero
		throw new UnsupportedOperationException();
	}

	public double getTamanho() {
		// TODO - implement Media.getTamanho
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param addDate
	 */
	public void setAddDate(LocalDate addDate) {
		this.addDate = addDate;
	}

	/**
	 * 
	 * @param TamanhoBytes
	 */
	public void setTamanhoBytes(double TamanhoBytes) {
		// TODO - implement Media.setTamanhoBytes
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Género
	 */
	public void setGénero(String Género) {
		// TODO - implement Media.setGénero
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Titulo
	 */
	public void setTitulo(String Titulo) {
		// TODO - implement Media.setTitulo
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Tempo
	 */
	public void setTempo(int Tempo) {
		// TODO - implement Media.setTempo
		throw new UnsupportedOperationException();
	}

	public int getID() {
		// TODO - implement Media.getID
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ID
	 */
	public void setID(int ID) {
		// TODO - implement Media.setID
		throw new UnsupportedOperationException();
	}

	public String getDiretorio() {
		// TODO - implement Media.getDiretório
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Diretório
	 */
	public void setDiretorio(String Diretório) {
		// TODO - implement Media.setDiretório
		throw new UnsupportedOperationException();
	}

	public boolean getIsPublic() {
		return this.isPublic;
	}

	/**
	 * 
	 * @param isPublic
	 */
	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getUploader() {
		return this.uploader;
	}

	/**
	 * 
	 * @param uploader
	 */
	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public List<String> getInfoMedia() {
		// TODO - implement Media.getInfoMedia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Titulo
	 * @param Tempo
	 * @param genero
	 * @param diretorio
	 * @param isPublic
	 * @param uploader
	 */
	public Media(String Titulo, int Tempo, String genero, int diretorio, boolean isPublic, String uploader) {
		// TODO - implement Media.Media
		throw new UnsupportedOperationException();
	}

}