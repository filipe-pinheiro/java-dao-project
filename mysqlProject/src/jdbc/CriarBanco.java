package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:mysql://localhost:3306";
		String usuario = "root";
		String senha = "0314";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS vasco_da_gama");
		
		System.out.println("Banco criado com sucesso");
		conexao.close();

	}

}
