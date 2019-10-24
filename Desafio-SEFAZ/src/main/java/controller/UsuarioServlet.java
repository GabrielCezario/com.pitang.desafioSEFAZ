package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

@WebServlet(urlPatterns = {"/cadastroUsuario", "/capturarUsuarios"})
public class UsuarioServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UsuarioController usuarioController = new UsuarioController();
		List<Usuario> usuarios = usuarioController.capturarUsuarios();
		
		resp.getWriter().print("<html>");
		resp.getWriter().print("<body>");
		
		
		for (Usuario usuario : usuarios) {
			resp.getWriter().println("Usuario: " + usuario.getId() + "<br>");
			resp.getWriter().println("Nome: " + usuario.getNome() + "<br>");
			resp.getWriter().println("Email: " + usuario.getEmail() + "<br>");
			resp.getWriter().println("Senha: " + usuario.getSenha() + "<br>");
			
			resp.getWriter().println("<p>");
		}
		
		resp.getWriter().print("<html>");
		
		resp.getWriter().print("</body>");
		resp.getWriter().print("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Usuario usuario = new Usuario();
		usuario.setNome(req.getParameter("nome"));
		usuario.setEmail(req.getParameter("email"));
		usuario.setSenha(req.getParameter("senha"));
		
		try {
			UsuarioController usuarioController = new UsuarioController();
			usuarioController.cadastrar(usuario);
		} catch (UsuarioInvalidoException | SQLException e) {
			e.printStackTrace();
			
		}
		
	}
	
}
