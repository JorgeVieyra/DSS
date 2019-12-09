package Diagrama_de_Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ColecaoDAO implements Map<String, List<Colecao>>{

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


    public Set<Map.Entry<String,List<Colecao>>> entrySet() {
        //TODO ANTONIO
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }

    public boolean equals(Object o) {
        //TODO ANTONIO
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }

    public List<Colecao> get(Object username) {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            List<Colecao> al = new ArrayList<Colecao>();
            Statement stm = conn.createStatement();
            String sql = String.format("SELECT * FROM Colecao WHERE criador='%s'", username);
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
                al.add(new Colecao(rs.getInt(1),rs.getString(2),rs.getString(3),true,false));
            return al;
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

    public Set<String> keySet() {
        throw new NullPointerException("Not defined.");
    }

    public List<Colecao> put(String key, List<Colecao> value) {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Conta al = null;
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM conta WHERE username='"+key+"'");
            String sql;// = String.format("INSERT INTO conta VALUES ('%s','%s','%d','%s')",value.getUsername(),value.getPassword(),?1:0,value.getEmail());
            //int i  = stm.executeUpdate(sql);
            return new ArrayList<Colecao>();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }


    public void putAll(Map<? extends String,? extends List<Colecao>> t) {
        //TODO ANTONIO
        throw new NullPointerException("Not implemented!");
    }

    public List<Colecao> remove(Object key) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("UPDATE Musica SET colecao = null WHERE colecao = '%s'",key));
            stm.executeUpdate(String.format("UPDATE Video SET colecao = null WHERE colecao = '%s'",key));
            stm.executeUpdate(String.format("DELETE FROM Colecao where idColecao = '%s",key));
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

    public Collection<List<Colecao>> values() {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Collection<List<Colecao>> col = new HashSet<List<Colecao>>();
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
