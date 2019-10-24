package controller;

public class UsuarioInvalidoException extends Exception{

	private boolean idVazio;
	private boolean nomeVazio;
	private boolean emailVazio;
	private boolean senhaVazio;
	
	public boolean isIdVazio() {
		return idVazio;
	}
	public void setIdVazio(boolean idVazio) {
		this.idVazio = idVazio;
	}
	public boolean isNomeVazio() {
		return nomeVazio;
	}
	public void setNomeVazio(boolean nomeVazio) {
		this.nomeVazio = nomeVazio;
	}
	public boolean isEmailVazio() {
		return emailVazio;
	}
	public void setEmailVazio(boolean emailVazio) {
		this.emailVazio = emailVazio;
	}
	public boolean isSenhaVazio() {
		return senhaVazio;
	}
	public void setSenhaVazio(boolean senhaVazio) {
		this.senhaVazio = senhaVazio;
	}
	
}
