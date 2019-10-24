<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		
		<style>
		
			form{
				border: 2px solid black;
				border-radius: 0px 50px 0px 50px;	
				box-shadow: 2px 2px 8px;	
				width: 280px;	
				height: 300px;
				
				margin-top: 10%;
				padding-top: 5%;
				margin-left: 40%;
				padding-left: 3%;
			}
			
			#btnEntrar{
				width: 220px;
				height: 35px;
			}
		
		</style>
		
	</head>

	<body>
		
		<a href="cadastroUsuario.jsp"> <input type="button" value="Cadastrar-se"> </a>
		<a href="listarTodos.jsp"> <input type="button" value="Listar todos"> </a>
		
		<hr>

		<form action="login" method="POST">
			
			Email:
			<input type="text" name="LoginEmail"/> 
			
			<p>Senha:
			<input type="password" name="loginSenha"/>
			
			<p><input type="submit" value="Entrar" id="btnEntrar"/>
			
		</form>
				
	</body>

</html>