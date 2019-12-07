package Diagrama_de_Classes;


/**
 * Exemplo de um DAO (para o acesso aos dados de Aluno).
 * Como forma de minimizar o impacto de alteração dos Diag de Sequência, o DAO assume
 * a API da estrutura de dados que substitui - neste caso vai substituir um Map de Aluno.
 * O DAO utiliza o padrão Singleton.
 *
 * DISCLAIMER: Este código foi criado para discussão e edição durante as aulas práticas
 * de DSS, representando uma solução em construção. Como tal, não deverá ser visto como
 * uma solução canónica, ou mesmo acabada. É disponibilizado para auxiliar o processo de
 * estudo. Os alunos são encorajados a testar adequadamente o código fornecido e a procurar
 * soluções alternativas, à medida que forem adquirindo mais conhecimentos. Por exemplo,
 * protegendo o DAO de ataques por SQL injection.
 *
 * @author jfc
 * @version 20191125
 */

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

    public Set<Map.Entry<String,Conta>> entrySet() {
        //TODO ANTONIO
        throw new NullPointerException("public Set<Map.Entry<String,Aluno>> entrySet() not implemented!");
    }

    public boolean equals(Object o) {
        //TODO ANTONIO
        throw new NullPointerException("public boolean equals(Object o) not implemented!");
    }

    public Conta get(Object username) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Conta al = null;
            Statement stm = conn.createStatement();
            //Criar lista de colecoes
            ArrayList colList = new ArrayList<String>();
            String colecoes = String.format("select c.idColecao from colecao c where c.criador = '%s'", username);
            ResultSet colecoesrs = stm.executeQuery(colecoes);
            while (colecoesrs.next())
                colList.add(colecoesrs.getString(1));

            //Criar lista de amigos
            ArrayList friendList = new ArrayList<String>();
            String friends = String.format("SELECT user2 FROM Amizade where user1 = '%s' Union ALL SELECT user1 FROM Amizade where user2 = '%s'", username,username);
            ResultSet friendrs = stm.executeQuery(friends);
            while (friendrs.next())
                friendList.add(friendrs.getString(1));

            String sql = "SELECT * FROM Conta WHERE username='"+(String)username+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next())
                al = new Conta(rs.getString(1),rs.getString(4),rs.getString(2),colList,friendList);
            return al;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public int hashCode() {
        return this.inst.hashCode();
    }

    public boolean isEmpty() {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT username FROM conta");
            return !rs.next();
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

    public Set<String> keySet() {
        throw new NullPointerException("Not defined.");
    }

    public Conta put(String key, Conta value) {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Conta al = null;
            Statement stm = conn.createStatement();
            stm.executeUpdate("DELETE FROM Conta WHERE username='"+key+"'");
            String sql = String.format("INSERT INTO Conta VALUES ('%s','%s','%d','%s')",value.getUsername(),value.getPassword(),(value instanceof Conta_Admin)?1:0,value.getEmail());
            int i  = stm.executeUpdate(sql);
            if(value instanceof Conta_Admin){
                return new Conta_Admin(value.getUsername(),value.getPassword(),value.getEmail());
            }else {
                return new Conta(value.getUsername(),value.getPassword(),value.getEmail());
            }
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }


    public void putAll(Map<? extends String,? extends Conta> t) {
        //TODO ANTONIO
        throw new NullPointerException("Not implemented!");
    }

    public Conta remove(Object key) {
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123&serverTimezone=UTC")) {
            Conta al = this.get(key);
            Statement stm = conn.createStatement();
            String sql = String.format("DELETE FROM conta where username ='%s'",key);
            int i  = stm.executeUpdate(sql);
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
        //TODO ANTONIO
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/MediaCenter?user=root&password=frango123")) {
            Collection<Conta> col = new HashSet<Conta>();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM conta");
            for (;rs.next();) {
                if(rs.getBoolean(3)){
                    col.add(new Conta_Admin(rs.getString(1),rs.getString(2),rs.getString(4)));
                }else{
                    col.add(new Conta(rs.getString(1),rs.getString(2),rs.getString(4)));
                }
            }
            return col;
        }
        catch (Exception e) {throw new NullPointerException(e.getMessage());}
    }

}

