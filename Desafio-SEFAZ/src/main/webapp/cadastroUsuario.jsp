<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

	<head>
		<meta charset="UTF-8">
		<title>Cadastrar</title>
	</head>
	
	<body>
	
		<a href="index.jsp"> <input type="button" value="Voltar"/> </a>
		
		<hr>
		
		<form action="cadastroUsuario" method="POST">
		
			Nome: <input type="text" name="nome"/>
			Email:<input type="text" name="email"/>
			
			<p> Telefone: <input type="text" name="telefone"/>
			Senha: <input type="password" name="senha"/>
			
			<p> <input type="submit" value="Cadastrar-se"/>
		
		</form>
	
	</body>
</html>