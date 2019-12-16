package Diagrama_de_Classes;

import java.util.*;
import java.sql.*;
import java.sql.DriverManager;


public class ContaDAO implements Map<String,Conta> {

    private static ContaDAO inst = null;

    private ContaDAO () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {throw new NullPointerException(e.getMessage());}
    }

    public static ContaDAO getInstance() {
        if (inst == null) {
            inst = new ContaDAO();
        }
        return inst;
    }

    public void clear () {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Statement stm = conn.createStatement();
            stm.executeUpdate("UPDATE Musica SET uploader = null WHERE isPublic = 1");
            stm.executeUpdate("UPDATE Video SET uploader = null WHERE isPublic = 1");
            stm.executeUpdate("UPDATE Colecao SET criador = null WHERE isPublic = 1");
            stm.executeUpdate("DELETE FROM Conta");
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public boolean containsKey(Object key) throws NullPointerException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Statement stm = conn.createStatement();
            String sql = "SELECT username FROM Conta WHERE username='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public boolean containsValue(Object value) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * from Conta");
            while(rs.next())
                for(int i = 1;i<=rs.getMetaData().getColumnCount();i++)
                    if(Objects.equals(value,rs.getString(i))) return true;
            return false;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public Set<Map.Entry<String,Conta>> entrySet() {
        //TODO ANTONIO
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }

    public boolean equals(Object o) {
        //TODO ANTONIO
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }

    public Conta get(Object username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {

            Statement stm = conn.createStatement();
            //Criar lista de colecoes
            List<Integer> colList = new ArrayList<Integer>();
            String colecoes = String.format("select c.idColecao from Colecao c where c.criador = '%s'", username);
            ResultSet colecoesrs = stm.executeQuery(colecoes);
            while (colecoesrs.next())
                colList.add(colecoesrs.getInt(1));

            //Criar lista de amigos
            List<String> friendList = new ArrayList<String>();
            String friends = String.format("SELECT user2 FROM Amizade where user1 = '%s' Union ALL SELECT user1 FROM Amizade where user2 = '%s'", username,username);
            ResultSet friendrs = stm.executeQuery(friends);
            while (friendrs.next())
                friendList.add(friendrs.getString(1));

            String sql = "SELECT * FROM Conta WHERE username='"+(String)username+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                if(rs.getInt(3) == 1)
                    return new Conta_Admin(rs.getString(1),rs.getString(4),rs.getString(2),colList,friendList);
                else
                    return new Conta(rs.getString(1),rs.getString(4),rs.getString(2),colList,friendList);
            }
            return null;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public int hashCode() {
        return this.inst.hashCode();
    }

    public boolean isEmpty() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT username FROM Conta");
            return !rs.next();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public Set<String> keySet() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Set<String> setKeys = new HashSet<>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT username FROM Conta");
            while (rs.next()) setKeys.add(rs.getString(1));
            return setKeys;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public Conta put(String key, Conta value) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            //TODO ANTONIO colocar colecao e colocar lista amigos
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Conta WHERE username='"+key+"'");
            String sql = String.format("INSERT INTO Conta VALUES ('%s','%s','%d','%s')",value.getUsername(),value.getPassword(),(value instanceof Conta_Admin)?1:0,value.getEmail());
            stm.executeUpdate(sql);
            if(value instanceof Conta_Admin){
                return new Conta_Admin(value.getUsername(),value.getPassword(),value.getEmail(),value.getColecoes(),value.getListaAmigos());
            }else {
                return new Conta(value.getUsername(),value.getPassword(),value.getEmail(),value.getColecoes(),value.getListaAmigos());
            }
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }


    public void putAll(Map<? extends String,? extends Conta> t) {
        //TODO ANTONIO
        throw new NullPointerException("Not implemented!");
    }

    public Conta remove(Object key) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Conta al = this.get(key);
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("UPDATE Musica SET uploader = null WHERE uploader = '%s' and isPublic = 1",key));
            stm.executeUpdate(String.format("UPDATE Video SET uploader = null WHERE uploader = '%s' and isPublic = 1",key));
            stm.executeUpdate(String.format("UPDATE Colecao SET criador = null WHERE criador = '%s' and isPublic = 1",key));
            stm.executeUpdate(String.format("DELETE FROM Conta where username ='%s'",key));
            return al;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public int size() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT username FROM Conta");
            for (;rs.next();i++);
            return i;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public Collection<Conta> values() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Collection<Conta> col = new HashSet<Conta>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM Conta");
            for (;rs.next();)  col.add(this.get(rs.getString(1)));
            return col;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public void updatePassword(String username,String password){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("UPDATE Conta SET senha = '%s' WHERE username = '%s'",password,username));
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public void updateEmail(String username,String email){
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Statement stm = conn.createStatement();
            stm.executeUpdate(String.format("UPDATE Conta SET email = '%s' WHERE username = '%s'",email,username));
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

}


