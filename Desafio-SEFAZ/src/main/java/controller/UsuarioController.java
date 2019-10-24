package controller;

import java.sql.SQLException;
import java.util.List;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
	
	public void cadastrar(Usuario usuario) throws UsuarioInvalidoException, SQLException{
		
		UsuarioInvalidoException usuarioInvalidoException = verificarUsuario(usuario);
		
		if (usuarioInvalidoException != null) {
			throw usuarioInvalidoException;
		} else {
			UsuarioDAO.create(usuario);
		}
		
	}
	
	public List<Usuario> capturarUsuarios(){
		return UsuarioDAO.retrive();
	}
	
	//METODOS PRIVADOS
	
	public UsuarioInvalidoException verificarUsuario(Usuario usuario) {
		
		UsuarioInvalidoException usuarioInvalidoException = null;
		
		if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
			if (usuarioInvalidoException == null) {
				usuarioInvalidoException = new UsuarioInvalidoException();
			}
			
			usuarioInvalidoException.setEmailVazio(true); 
		}
		
		if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
			if (usuarioInvalidoException == null) {
				usuarioInvalidoException = new UsuarioInvalidoException();
			}
			
			usuarioInvalidoException.setEmailVazio(true);
		}
		
		if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
			if (usuarioInvalidoException == null) {
				usuarioInvalidoException = new UsuarioInvalidoException();
			}
			
			usuarioInvalidoException.setSenhaVazio(true);
		}
		
		return usuarioInvalidoException;
	}

}
