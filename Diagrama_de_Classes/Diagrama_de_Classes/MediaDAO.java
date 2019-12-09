package Diagrama_de_Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

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
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Statement stm = conn.createStatement();
			stm.executeUpdate("DELETE FROM Conta");
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public boolean containsKey(Object key) throws NullPointerException {
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Statement stm = conn.createStatement();
			String sql = "SELECT username FROM conta WHERE username='"+(String)key+"'";
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
		//TODO ANTONIO
		throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
	}

	public boolean equals(Object o) {
		//TODO ANTONIO
		throw new NullPointerException("public boolean equals(Object o) not implemented!");
	}

	public Media get(Object id) {
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Media al = null;
			Statement stm = conn.createStatement();
			String sql = String.format("SELECT * FROM Musica WHERE idMusica = %d",id);
			ResultSet rs = stm.executeQuery(sql);
			System.out.println(rs.toString());
			if (rs.next())
				//al = new Media(id,rs.getString(),"",true,true/*rs.getString(4),rs.getString(2),rs.getString(1)*/);
			return al;
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
		return null;
	}

	public int hashCode() {
		return inst.hashCode();
	}

	public boolean isEmpty() {
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT username FROM conta");
			return !rs.next();
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public Set<Integer> keySet() {
		throw new NullPointerException("Not defined.");
	}

	public Media put(Integer key, Media value) {
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Conta al = null;
			Statement stm = conn.createStatement();
			stm.executeUpdate("DELETE FROM conta WHERE username='"+key+"'");
			String sql;// = String.format("INSERT INTO conta VALUES ('%s','%s','%d','%s')",value.getUsername(),value.getPassword(),?1:0,value.getEmail());
			//int i  = stm.executeUpdate(sql);
			return null;//new Colecao(1,"","",true,true/*value.getUsername(),value.getPassword(),value.getEmail()*/);
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}


	public void putAll(Map<? extends Integer,? extends Media> t) {
		//TODO ANTONIO
		throw new NullPointerException("Not implemented!");
	}

	public Media remove(Object key) {
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Media al = this.get(key);
			Statement stm = conn.createStatement();
			String sql = "DELETE '"+key+"' FROM TAlunos";
			int i  = stm.executeUpdate(sql);
			return al;
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public int size() {
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			int i = 0;
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT nome FROM TAlunos");
			for (;rs.next();i++);
			return i;
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

	public Collection<Media> values() {
		//TODO ANTONIO
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
			Collection<Media> col = new HashSet<Media>();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM conta");
			for (;rs.next();) {
				//col.add(new Colecao(rs.getString(1),rs.getString(2),rs.getString(4)));
			}
			return col;
		}
		catch (Exception e) {throw new NullPointerException(e.getMessage());}
	}

}