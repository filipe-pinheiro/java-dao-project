package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabela {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conexao = CriarConexao.getConexao();
		
		String sql = "CREATE TABLE IF NOT EXISTS jogo("
				+ "codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nome VARCHAR(80) NOT NULL,"
				+ "ano VARCHAR(4) NOT NULL"
				+ ")";
		
		Statement stmt = conexao.createStatement();
		stmt.execute(sql);
		
		System.out.println("Tabela criada com sucesso");
		conexao.close();
		
	}

}
