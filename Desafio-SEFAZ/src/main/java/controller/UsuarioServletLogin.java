package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

@WebServlet(urlPatterns = {"/login"})
public class UsuarioServletLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario us = new Usuario();
		
		String loginEmail = request.getParameter("loginEmail");
		String loginSenha = request.getParameter("loginSenha");
		
		UsuarioController usuarioController = new UsuarioController();
		List<Usuario> usuarios = usuarioController.capturarUsuarios();
		
		for (Usuario usuario : usuarios) {
			
			if (usuario.getEmail() == loginEmail && usuario.getSenha() == loginSenha) {
				
				us.setId(usuario.getId());
				us.setNome(usuario.getNome());
				us.setEmail(usuario.getEmail());
				us.setSenha(usuario.getSenha());
				
			}
		}
		
		response.getWriter().print("<html>");
		response.getWriter().print("<body>");
		
		response.getWriter().println("Usuario: " + us.getId() + "<br>");
		response.getWriter().println("Nome: " + us.getNome() + "<br>");
		response.getWriter().println("Email: " + us.getEmail() + "<br>");
		response.getWriter().println("Senha: " + us.getSenha() + "<br>");
		
		response.getWriter().print("</body>");
		response.getWriter().print("</html>");
		
	}

}
