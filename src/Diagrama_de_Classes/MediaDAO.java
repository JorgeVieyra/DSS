package Diagrama_de_Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.time.LocalDate;


public class MediaDAO implements Map<Integer,Media>{
	private static MediaDAO inst = null;

	private MediaDAO () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {throw new NullPointerException(e.getMessage());}
	}

	public static MediaDAO getInstance() {
		if (inst == null) {
			inst = new MediaDAO();
		}
		return inst;
	}

	public void clear () {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Statement stm = conn.createStatement();
			stm.executeUpdate("DELETE FROM Video");
			stm.executeUpdate("DELETE FROM Musica");
			stm.executeUpdate("DELETE FROM MediaID");
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public boolean containsKey(Object key) throws NullPointerException {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Statement stm = conn.createStatement();
			String sql = String.format("SELECT idMedia FROM MediaID WHERE idMedia='%s'", key);
			ResultSet rs = stm.executeQuery(sql);
			return rs.next();
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public boolean containsValue(Object value) {
		//TODO ANTONIO
		throw new NullPointerException("public boolean containsValue(Object value) not implemented!");
	}

	public Set<Map.Entry<Integer,Media>> entrySet() {

		throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
	}

	public boolean equals(Object o) {
		//TODO ANTONIO
		throw new NullPointerException("public boolean equals(Object o) not implemented!");
	}

	public Media get(Object id) {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Media al = null;
			Statement stm = conn.createStatement();
			String sql = String.format("SELECT * FROM Musica WHERE idMusica = %d", id);
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()){
				al = new Musica(rs.getInt(1), rs.getString(2), Arrays.asList(rs.getString(3).split("&")), 0, null, rs.getString(8), rs.getBoolean(7), rs.getString(6));
				return al;}
			else{
				String sql1 = String.format("SELECT * FROM Video WHERE idVideo = %d", id);
				ResultSet rs1 = stm.executeQuery(sql1);
				rs1.next();
				al = new Video(rs1.getInt(1),rs1.getString(2),0,null,rs1.getString(7),rs1.getBoolean(6),rs1.getString(5),null,30);
				return al;}
		}
		catch (Exception e) {return null;}

	}

	public int hashCode() {
		return 1;
	}

	public boolean isEmpty() {

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT titulo FROM Musica");
			ResultSet rs1 = stm.executeQuery("SELECT titulo FROM Video");
			return !rs.next() && !rs1.next();
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public Set<Integer> keySet() {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
			Set<Integer> setKeys = new HashSet<>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT idMedia FROM MediaID");
			while (rs.next()) setKeys.add(rs.getInt(1));
			return setKeys;
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public Media put(Integer key, Media value) {
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Conta al = null;
			Statement stm = conn.createStatement();
			this.remove(key);
			if (value instanceof Musica)
				stm.executeUpdate(String.format("INSERT INTO Musica (idMusica, titulo, artista, dataInclusao, colecao, uploader, isPublic,caminho) VALUES ('%s','%s','%s','%s','%s','%s','%s','%s')",key,value.getTitulo(),((Musica) value).getArtista(),LocalDate.now(),null,value.getUploader(),value.getIsPublic()?1:0,value.getDiretorio()));
			else
				stm.executeUpdate(String.format("INSERT INTO Video (idVideo, titulo, dataInclusao, colecao, uploader, isPublic,caminho) VALUES ('%s','%s','%s','%s','%s','%s','%s')",key,value.getTitulo(),LocalDate.now(),null,value.getUploader(),value.getIsPublic()?1:0,value.getDiretorio()));

			stm.executeUpdate(String.format("INSERT INTO MediaID VALUES ('%s')",key));

			//int i  = stm.executeUpdate(sql);
			return value;
		}
		catch (Exception e) {e.printStackTrace();;throw new NullPointerException(e.getMessage());}
	}


	public void putAll(Map<? extends Integer,? extends Media> t) {
		//TODO ANTONIO
		throw new NullPointerException("Not implemented!");
	}

	public Media remove(Object key) {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Media al = this.get(key);
			if(al != null) {
				Statement stm = conn.createStatement();
				if (al instanceof Video)
					stm.executeUpdate(String.format("DELETE From Video WHERE idVideo = '%s'",key));
				else
					stm.executeUpdate(String.format("DELETE From Musica WHERE idMusica = '%s'",key));

				stm.executeUpdate(String.format("DELETE From MediaID WHERE idMedia = '%s'",key));
			}

			return al;
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public int size() {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			int i = 0,j=0;
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT titulo FROM Musica");
			for (;rs.next();i++);
			ResultSet rs1 = stm.executeQuery("SELECT titulo FROM Video");
			for (;rs1.next();j++);
			return i+j;
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public Collection<Media> values() {
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Collection<Media> col = new HashSet<Media>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM Musica");
			for (;rs.next();)  col.add(new Musica(rs.getInt(1), rs.getString(2), Arrays.asList(rs.getString(3).split("&")), 0, null, rs.getString(8), rs.getBoolean(7), rs.getString(6)));
			ResultSet rs1 = stm.executeQuery("SELECT * FROM Video");
			for (;rs1.next();)  col.add(new Video(rs1.getInt(1),rs1.getString(2),0,null,rs1.getString(7),rs1.getBoolean(6),rs1.getString(5),null,30));
			return col;
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	/**
	 *  Verifica se um determinado ID corresponde a uma musica 
	 * @param id o id da potencial musica
	 * @return se for musica True, se não for musica False
	 */
	protected Boolean isMusic(Integer id){
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Collection<Media> col = new HashSet<Media>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(String.format("SELECT idMusica FROM Musica WHERE idMusica = '%s'",id));
			return rs.next();
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	protected Boolean isVideo(Integer id){
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Collection<Media> col = new HashSet<Media>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(String.format("SELECT idVideo FROM Video WHERE idVideo = '%s'",id));
			return rs.next();
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}
}