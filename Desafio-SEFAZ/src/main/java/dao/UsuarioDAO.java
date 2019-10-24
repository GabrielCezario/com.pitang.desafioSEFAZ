package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO {

	private static Connection conn = null;
	
	//Comandos SQL
	private final static String SQL_CREATE_USUARIO = "insert into usuarios (NOME, EMAIL, SENHA) values (?,?,?)";
	private final static String SQL_RETRIVE_ALL_USUARIO = "select * from usuarios";
	private final static String SQL_UPDATE_USUARIO = "update usuarios set nome = ?, email = ?, senha = ?";
	private final static String SQL_DELETE_USUARIO = "delete from usuarios where id = ?";
	
	public static void create(Usuario usuario) throws SQLException {
		
		conn = new ConnectionFactory().getConnection();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(SQL_CREATE_USUARIO);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
			
			stmt.close();
			conn.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
	public static List<Usuario> retrive(){
		
		conn = new ConnectionFactory().getConnection();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(SQL_RETRIVE_ALL_USUARIO);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getLong("ID"));
				usuario.setNome(rs.getString("Nome"));
				usuario.setEmail(rs.getString("Email"));
				usuario.setSenha(rs.getString("Senha"));
				usuarios.add(usuario);
				
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
	public static void update(Usuario usuario) throws SQLException {
		
		conn = new ConnectionFactory().getConnection();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE_USUARIO);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
	public static void delete(Usuario usuario) throws SQLException {
		
		conn = new ConnectionFactory().getConnection();
		
		try {
			
			PreparedStatement stmt = conn.prepareStatement(SQL_DELETE_USUARIO);
			stmt.setLong(1, usuario.getId());
			stmt.execute();
			
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		
	}
	
}
