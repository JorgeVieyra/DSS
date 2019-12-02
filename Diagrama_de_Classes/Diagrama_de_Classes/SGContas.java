package Diagrama_de_Classes;

import java.util.List;
import java.util.Map;

public class SGContas {

	private Map<String, Conta> Contas;
	private Conta ContaTemp;
	private boolean isConvidado = false;

	/**
	 * 
	 * @param email
	 * @param password
	 * @param username
	 * @param isAdmin
	 */
	public boolean addConta(String email, int password, String username, boolean isAdmin) {
		// TODO - implement SGContas.addConta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean removeConta(String id) {
		// TODO - implement SGContas.removeConta
		throw new UnsupportedOperationException();
	}

	public Map<String, Conta> getContas() {
		// TODO - implement SGContas.getContas
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ind
	 */
	public Conta getConta(String ind) {
		// TODO - implement SGContas.getConta
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param password
	 * @param username
	 */
	public void changePassword(String password, String username) {
		// TODO - implement SGContas.changePassword
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param username
	 */
	public boolean changeEmail(String email, String username) {
		// TODO - implement SGContas.changeEmail
		throw new UnsupportedOperationException();
	}

	public Conta getContaTemp() {
		// TODO - implement SGContas.getContaTemp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ContaTemp
	 */
	public boolean setContaTemp(Conta ContaTemp) {
		// TODO - implement SGContas.setContaTemp
		throw new UnsupportedOperationException();
	}

	public String getUsernameTemp() {
		// TODO - implement SGContas.getUsernameTemp
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 */
	public boolean verificaUsername(String username) {
		// TODO - implement SGContas.verificaUsername
		throw new UnsupportedOperationException();
	}

	public boolean getIsConvidado() {
		return this.isConvidado;
	}

	/**
	 * 
	 * @param isConvidado
	 */
	public void setIsConvidado(boolean isConvidado) {
		this.isConvidado = isConvidado;
	}

	public boolean logoutContaTemp() {
		// TODO - implement SGContas.logoutContaTemp
		throw new UnsupportedOperationException();
	}

	public boolean removeContaLoggedIn() {
		// TODO - implement SGContas.removeContaLoggedIn
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param username
	 */
	public boolean verificaUsernameExistente(String username) {
		// TODO - implement SGContas.verificaUsernameExistente
		throw new UnsupportedOperationException();
	}

	public List<Integer> getColecoesUser() {
		// TODO - implement SGContas.getColecoesUser
		throw new UnsupportedOperationException();
	}

}