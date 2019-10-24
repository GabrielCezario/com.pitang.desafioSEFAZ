package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	/*
	 * Eu sei que não se coloca o caminho absoluto, mas eu tentei colocar apenas o caminho do banco ele ficou dando erro.
	 * A única maneira que eu consegui fazer o banco funcionar, foi passando o caminho absoluto na URL.
	 * 
	 * Então... me desculpe xD
	 * 
	 */
	
	public static final String URL = "jdbc:hsqldb:file:C:\\Users\\Gabriel\\Desktop\\Desafio SEFAZ\\desafioSEFAZ\\basebd\\bd;ifexists=true";
	public static String user = "SA";
	public static String psw = "";
	
	Connection conn = null;
	
	public Connection getConnection() {
		
		try {
			
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			conn = DriverManager.getConnection(URL, user, psw);
			return conn;
			
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException();
		}

	}

}
