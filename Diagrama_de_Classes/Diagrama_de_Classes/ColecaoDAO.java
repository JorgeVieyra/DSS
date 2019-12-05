package Diagrama_de_Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ColecaoDAO implements Map<Integer,Colecao>{

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

    public Set<Map.Entry<Integer,Colecao>> entrySet() {
        //TODO ANTONIO
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }

    public boolean equals(Object o) {
        //TODO ANTONIO
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }

    public Colecao get(Object username) {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Colecao al = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Conta WHERE username='"+(String)username+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next())
                al = new Colecao(1,"","",true,true/*rs.getString(4),rs.getString(2),rs.getString(1)*/);
            return al;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
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

    public Colecao put(Integer key, Colecao value) {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Conta al = null;
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM conta WHERE username='"+key+"'");
            String sql;// = String.format("INSERT INTO conta VALUES ('%s','%s','%d','%s')",value.getUsername(),value.getPassword(),?1:0,value.getEmail());
            //int i  = stm.executeUpdate(sql);
            return new Colecao(1,"","",true,true/*value.getUsername(),value.getPassword(),value.getEmail()*/);
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }


    public void putAll(Map<? extends Integer,? extends Colecao> t) {
        //TODO ANTONIO
        throw new NullPointerException("Not implemented!");
    }

    public Colecao remove(Object key) {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Colecao al = this.get(key);
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

    public Collection<Colecao> values() {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Collection<Colecao> col = new HashSet<Colecao>();
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
