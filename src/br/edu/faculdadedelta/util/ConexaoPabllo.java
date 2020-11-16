package br.edu.faculdadedelta.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoPabllo {

	public Connection conectarNoBanco() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.postgresql.Driver");
		
		Connection conn = null;
		
		String url = "jdbc:postgresql://localhost/Delta";
		String usuario = "pabllo";
		String senha = "123456";
		
		conn = DriverManager.getConnection(url, usuario, senha);
		
		return conn;
	}
	
	public static void main(String[] args) {
		ConexaoPabllo conexao = new ConexaoPabllo();
		try {
			conexao.conectarNoBanco();
			System.out.println("Conectou no banco de dados!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

