package Logica_De_Negocio;


import DAOS.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SGCol {

	private ColecaoDAO colecoes;
	private Colecao colecaoTemp;
	private MediaDAO medias;

	public SGCol(){
		this.colecoes = ColecaoDAO.getInstance();
		this.medias = MediaDAO.getInstance();
	}

	/**
	 *
	 * @param id
	 * @param colecao
	 */
	public void addColecao(int id, Colecao colecao) {
		colecoes.put(id,colecao);
		for(Media m : colecao.getMedias())
			addToCol(m.getID(),colecao.getID());
	}

	/**
	 * 
	 * @param idColection
	 */
	public void removeColecao(int idColection) {
		colecoes.remove(idColection);
	}

	//empty
	public Colecao criarColecao(int id, String titulo, String criador, String categoria, boolean isPublic){
		return new Colecao(id,titulo,criador,categoria,isPublic);
	}
	//recebe medias
	public Colecao criarColecao(int id, String titulo, String criador, String categoria, boolean isPublic, List<Integer> novasMedias){
		return new Colecao(id,titulo,criador,categoria,isPublic,novasMedias);
	}

	public List<Media> getMediaByType(String type){
		if(type.toLowerCase().equals("video")) return medias.values().stream().filter(m -> m instanceof Video).collect(Collectors.toList());
		else return medias.values().stream().filter(m -> m instanceof Musica).collect(Collectors.toList());
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

	public List<Colecao> PublicCols(){
		return colecoes.getPublicCols();
	}

	/**
	 * @param novaMedia
	 */
	public void addMediaColTemp(Media novaMedia) {
		this.colecaoTemp.getMedias().add(novaMedia);
	}

	/**
	 * 
	 * @param idMedia
	 */
	public void removeMediaFromCol(int idMedia) {
		this.colecaoTemp.getMedias().remove(idMedia);
	}

	public void removeMedia(int idMedia) throws IOException {
		Files.deleteIfExists(Paths.get(medias.get(idMedia).getDiretorio()));
		this.medias.remove(idMedia);
	}

	public List<Media> getAllMedia(){return medias.valuesList();}

	public Integer getFirstAvailiableMediaID(){
		Set<Integer> ids = medias.keySet();
		Integer i = 1;
		for(;ids.contains(i);i++);
		return i;
	}

	public Integer getFirstAvailiableID(){
		Set<Integer> ids = colecoes.keySet();
		Integer i = 1;
		for(;ids.contains(i);i++);
		return i;
	}

	public Integer getFirstAvailiableRelID(){
		Set<Integer> ids = colecoes.keySetRel();
		Integer i = 1;
		for(;ids.contains(i);i++);
		return i;
	}

	public void addToCol(Integer media,Integer col){
		colecoes.addRelationship(getFirstAvailiableRelID(),media,col);
	}

	/**
	 *
	 * @param id
	 */
	public Colecao getColecao(int id) {
		return colecoes.get(id);
	}

	public List<Media> getAvailiableMedia(String username){return medias.Availiablevalues(username);}

	public List<Media> getMediaOfUser(String username){return medias.getMediaOfUtilizador(username);}

	public void removeRelationship(Integer mediaID, Integer colID){colecoes.removeRelationship(mediaID,colID);}

	public void addMediaToDB(String uploader,String titulo,String artista,String caminho,Boolean isPublic,Boolean isVideo){
		if(isVideo) medias.put(getFirstAvailiableMediaID(),new Video(getFirstAvailiableMediaID(),titulo,-1,null,caminho,isPublic,uploader,null,-1));
		else medias.put(getFirstAvailiableMediaID(),new Musica(getFirstAvailiableMediaID(),titulo, Arrays.stream(artista.split("&")).collect(Collectors.toList()), -1,null,caminho,isPublic,uploader, LocalDate.now()));
	}
}