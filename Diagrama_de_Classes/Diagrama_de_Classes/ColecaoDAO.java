package Diagrama_de_Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ColecaoDAO implements Map<Integer, Colecao>{


    private static ColecaoDAO inst = null;
    private ColecaoDAO () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {throw new NullPointerException(e.getMessage());}
    }

    public static ColecaoDAO getInstance() {
        if (inst == null) {
            inst = new ColecaoDAO();
        }
        return inst;
    }

    public void clear () {
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
                Statement stm = conn.createStatement();
                stm.executeUpdate("UPDATE Musica SET colecao = null");
                stm.executeUpdate("UPDATE Video SET colecao = null");
                stm.executeUpdate("DELETE FROM Colecao");
            }
            catch (Exception e) {throw new NullPointerException(e.getMessage());}
        }

    public boolean containsKey(Object key) throws NullPointerException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Statement stm = conn.createStatement();
            String sql = String.format("SELECT idColecao FROM Colecao WHERE idColecao='%s'", key);
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public boolean containsValue(Object value) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * from Colecao");
            while(rs.next())
                for(int i = 1;i<=rs.getMetaData().getColumnCount();i++)
                    if(Objects.equals(value,rs.getString(i))) return true;
            return false;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }


    public Set<Map.Entry<Integer,Colecao>> entrySet() {
        //TODO ANTONIO
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }

    public boolean equals(Object o) {
        //TODO ANTONIO
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }

    public Colecao get(Object id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Statement stm = conn.createStatement();
            String sql = String.format("SELECT * FROM Colecao WHERE idColecao='%s'", id);
            ResultSet rs = stm.executeQuery(sql);
            return new Colecao(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),true);
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public int hashCode() {
        return inst.hashCode();
    }

    public boolean isEmpty() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT idColecao FROM Colecao");
            return !rs.next();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public Set<Integer> keySet() {
        throw new NullPointerException("Not defined.");
    }

    public Colecao put(Integer key, Colecao value) {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Colecao al = null;
            Statement stm = conn.createStatement();
            //stm.executeUpdate("DELETE FROM Colecao WHERE idColecao='"+key+"'");
            String sql = String.format(String.format("INSERT INTO MediaCenter.Colecao (idColecao, criador, titulo, categoria, isPublic) VALUES('%s','%s','%s','%s','%s')", value.getID(),value.getCriador(),value.getTitulo(),value.getCategoria(),value.getisPublic()?1:0));
            int i  = stm.executeUpdate(sql);
                    //int i  = stm.executeUpdate(sql);
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
        return null;
    }


    public void putAll(Map<? extends Integer,? extends Colecao> t) {
        //TODO ANTONIO
        throw new NullPointerException("Not implemented!");
    }

    public Colecao remove(Object key) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Colecao al = this.get(key);
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("UPDATE Musica SET colecao = null WHERE colecao = '%s'",key));
            stm.executeUpdate(String.format("UPDATE Video SET colecao = null WHERE colecao = '%s'",key));
            stm.executeUpdate(String.format("DELETE FROM Colecao where idColecao = '%s",key));
            return al;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}

    }

    public int size() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT idColecao FROM Colecao");
            for (;rs.next();i++);
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public Collection<Colecao> values() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Collection<Colecao> col = new HashSet<Colecao>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Colecao");
            for (;rs.next();) {
                col.add(new Colecao(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),true));
            }
            return col;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

}
