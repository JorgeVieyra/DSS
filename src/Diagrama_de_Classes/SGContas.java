package Diagrama_de_Classes;

import java.util.Collection;
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
	 * @param isConvidado utilizador é convidado?
	 */
	public void setIsConvidado(boolean isConvidado) {
		this.isConvidado = isConvidado;
	}

	public List<Integer> getColecoesUser() throws InvalidUsernameException{
		if(contaTemp!=null && !usernameExiste(contaTemp.getUsername())) return contaTemp.getColecoes();
		else throw new InvalidUsernameException("Erro: Nome de Utilizador não existe ou utilizador não tem coleções.");
	}

	public Collection<Conta> getContas() {
		return contas.values();
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
	public void registarConta(String email, String password, String username, boolean isAdmin) throws InvalidUsernameException {
		Conta c;
		if(!usernameExiste(username)){
			if(!isAdmin) c = new Conta(email,password,username);
			else c = new Conta_Admin(email,password,username);
			contas.put(username,c);
		} else throw new InvalidUsernameException("Erro: Username não é unico.");
	}

	/**
	 * 
	 * @param username
	 */
	public void apagarConta(String username) throws InvalidUsernameException{
		if(usernameExiste(username)) contas.remove(username);
		else throw new InvalidUsernameException("Erro: Nome de Utilizador não existe.");
	}

	public void adicionarAmigo(String nomeAmigo) throws InvalidUsernameException, UserNotLoggedInException{
		if (contaTemp==null) throw new UserNotLoggedInException("Erro: Nenhuma sessão iniciada.");
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
		if(usernameExiste(username)) //contas.get(username).setPassword(password);
			contas.updatePassword(username,password);
		else throw new InvalidUsernameException("Erro: Nome de utilizador não existe.");

	}

	/**
	 * 
	 * @param email
	 * @param username
	 */
	public void alterarEmail(String email, String username) throws InvalidUsernameException{
		if(usernameExiste(username))// contas.get(username).setEmail(email);
			contas.updatePassword(username,email);
		else throw new InvalidUsernameException("Erro: Nome de utilizador não existe.");
	}

	public void login(String username, String password)throws InvalidUsernameException,InvalidPasswordException{
		if(!usernameExiste(username)) throw new InvalidUsernameException("Username não existe."); //username não existe erro
		if(!contas.get(username).getPassword().equals(password)) throw new InvalidPasswordException("Password incorreta."); //password errada erro
		this.contaTemp = contas.get(username);
	}

	public void logout() {
		if(contaTemp!=null){ /* Dá save das mudanças feitas na conta metendo na DAO (DAO apaga a anterior e troca pela nova)*/
			contas.put(contaTemp.getUsername(),contaTemp);
		}
		this.contaTemp = null;
	}

	public Boolean usernameExiste(String username){
		return contas.containsKey(username);
	}

	public void updateContaTemp(){
		contaTemp = contas.get(contaTemp.getUsername());
	}

	//endregion

}