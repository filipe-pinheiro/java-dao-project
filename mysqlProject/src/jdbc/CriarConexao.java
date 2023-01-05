package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
	
	public static Connection getConexao() {
		try {
			String url = "jdbc:mysql://localhost/vasco_da_gama";
			String usuario = "root";
			String senha = "0314";

			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e); 
		}
	}

}
