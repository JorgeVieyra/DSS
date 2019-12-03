package Diagrama_de_Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SGContas {

	private Map<String, Conta> contas;
	private Conta contaTemp;
	private boolean isConvidado = false;

	//region Construtores
	public SGContas(){
		this.contas = new HashMap<>();
		this.contaTemp = null;
		this.isConvidado = true;
		carregarContasSQL();
	}

	public SGContas(Map<String,Conta> contas){
		this.contas = new HashMap<>(contas);
		this.contaTemp = null;
		this.isConvidado = true;
		carregarContasSQL();
	}

	public SGContas(List<Conta> contas){
		this.contas = contas.stream().collect(Collectors.toMap(Conta::getUsername,c -> c));
		this.contaTemp = null;
		this.isConvidado = true;
		carregarContasSQL();
	}
	//endregion

	public boolean getIsConvidado() {
		return this.isConvidado;
	}

	//region Getters e Setters
	/**
	 *
	 * @param isConvidado utilizador é convidado?
	 */
	public void setIsConvidado(boolean isConvidado) {
		this.isConvidado = isConvidado;
	}

	public List<Integer> getColecoesUser() throws InvalidUsernameException{
		if(contaTemp!=null && !usernameExiste(contaTemp.getUsername())) return contaTemp.getColecoes();
		else throw new InvalidUsernameException("Erro: Nome de Utilizador não existe ou utilizador não tem coleções.");
	}

	public Map<String, Conta> getContas() {
		return new HashMap<>(contas);
	}

	/**
	 *
	 * @param username username
	 */
	public Conta getConta(String username) throws InvalidUsernameException {
		if(usernameExiste(username)) return contas.get(username);
		else throw new InvalidUsernameException("Erro: Nome de Utilizador não existe.");
	}

	//endregion

	/**
	 *
	 * @param email email
	 * @param password pass
	 * @param username user
	 * @param isAdmin is admin
	 */
	public void addConta(String email, String password, String username, boolean isAdmin) throws InvalidUsernameException {
		Conta c;
		if(!usernameExiste(username)){
			if(!isAdmin) c = new Conta(email,password,username);
			else c = new Conta_Admin(email,password,username);
			updateSQL(c);
			contas.put(username,c);
		} else throw new InvalidUsernameException("Erro: Username não é unico.");
	}

	/**
	 * 
	 * @param username
	 */
	public void removeConta(String username) throws InvalidUsernameException{
		if(usernameExiste(username)) contas.remove(username);
		else throw new InvalidUsernameException("Erro: Nome de Utilizador não existe.");
	}

	/**
	 * 
	 * @param password
	 * @param username
	 */
	public void changePassword(String password, String username) throws InvalidUsernameException{
		if(usernameExiste(username)) contas.get(username).setPassword(password);
		else throw new InvalidUsernameException("Erro: Nome de utilizador não existe.");

	}

	/**
	 * 
	 * @param email
	 * @param username
	 */
	public void changeEmail(String email, String username) throws InvalidUsernameException{
		if(usernameExiste(username)) contas.get(username).setEmail(email);
		else throw new InvalidUsernameException("Erro: Nome de utilizador não existe.");
	}

	public void logoutContaTemp() {
		this.contaTemp = null;
	}

	public boolean removeContaLoggedIn() {
		// TODO - implement SGContas.removeContaLoggedIn
		throw new UnsupportedOperationException();
	}

	public Boolean usernameExiste(String username){
		return contas.containsKey(username);
	}

	//region SQL Magic
	public void carregarContasSQL(){
		// TODO - António Santos Banderas
	}

	//adiciona a conta a base de dados
	public void updateSQL(Conta c){

	}

	//endregion

}