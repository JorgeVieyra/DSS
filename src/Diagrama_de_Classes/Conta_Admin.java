package Diagrama_de_Classes;

import java.util.List;

public class Conta_Admin extends Conta {
    /**
     * @param email email super
     * @param password password super
     * @param username username super
     */
    public Conta_Admin(String username, String email, String password, List<Integer> colecoes, List<String> listaAmigos) {
        super(username,email,password,colecoes,listaAmigos);
    }
    public Conta_Admin(String username, String email, String password) {
        super(username,email,password);
    }
}