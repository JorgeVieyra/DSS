package Diagrama_de_Classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SGContas {

	private ContaDAO contas;
	private Conta contaTemp;
	private boolean isConvidado = false;

	//region Construtores
	public SGContas(){
		this.contas = ContaDAO.getInstance();
		this.contaTemp = null;
		this.isConvidado = true;
	}

	//endregion

	public Conta getContaTemp(){
		return this.contaTemp;
	}

	//region Getters e Setters
	public boolean getIsConvidado() {
		return this.isConvidado;
	}

	/**
	 *
	 * @param isConvidado utilizador � convidado?
	 */
	public void setIsConvidado(boolean isConvidado) {
		this.isConvidado = isConvidado;
	}

	public List<Integer> getColecoesUser() throws InvalidUsernameException{
		if(contaTemp!=null && !usernameExiste(contaTemp.getUsername())) return contaTemp.getColecoes();
		else throw new InvalidUsernameException("Erro: Nome de Utilizador n�o existe ou utilizador n�o tem cole��es.");
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
		else throw new InvalidUsernameException("Erro: Nome de Utilizador n�o existe.");
	}

	//endregion

	/**
	 *
	 * @param email email
	 * @param password pass
	 * @param username user
	 * @param isAdmin is admin
	 */
	public void registarConta(String email, String password, String username, boolean isAdmin) throws InvalidUsernameException {
		Conta c;
		if(!usernameExiste(username)){
			if(!isAdmin) c = new Conta(email,password,username);
			else c = new Conta_Admin(email,password,username);
			contas.put(username,c);
		} else throw new InvalidUsernameException("Erro: Username n�o � unico.");
	}

	/**
	 * 
	 * @param username
	 */
	public void apagarConta(String username) throws InvalidUsernameException{
		if(usernameExiste(username)) contas.remove(username);
		else throw new InvalidUsernameException("Erro: Nome de Utilizador n�o existe.");
	}

	public void adicionarAmigo(String nomeAmigo) throws InvalidUsernameException{
		if(usernameExiste(nomeAmigo)) {
			contaTemp.addAmigo(nomeAmigo);
			contas.put(contaTemp.getUsername(),contaTemp);
		}
		else throw new InvalidUsernameException();
	}


	/**
	 * 
	 * @param password
	 * @param username
	 */
	public void alterarPassword(String password, String username) throws InvalidUsernameException{
		if(usernameExiste(username)) contas.get(username).setPassword(password);
		else throw new InvalidUsernameException("Erro: Nome de utilizador n�o existe.");

	}

	/**
	 * 
	 * @param email
	 * @param username
	 */
	public void alterarEmail(String email, String username) throws InvalidUsernameException{
		if(usernameExiste(username)) contas.get(username).setEmail(email);
		else throw new InvalidUsernameException("Erro: Nome de utilizador n�o existe.");
	}

	public void login(String username, String password)throws InvalidUsernameException,InvalidPasswordException{
		if(!usernameExiste(username)) throw new InvalidUsernameException(); //username n�o existe erro
		if(!contas.get(username).getPassword().equals(password)) throw new InvalidPasswordException(); //password errada erro
		this.contaTemp = contas.get(username);
	}

	public void logout() {
		this.contaTemp = null;
	}

	public Boolean usernameExiste(String username){
		return contas.containsKey(username);
	}

	//endregion

}