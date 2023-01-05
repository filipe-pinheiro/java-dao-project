package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class JogoDAO {
	
	public Connection conexao;

	public Connection getConexao() {
		try {
			if(conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {
			
		}
		
		conexao = CriarConexao.getConexao();
		return conexao;
		
	}
	
	public void adiciona(Jogo c) {
		String sql = "INSERT INTO jogo("
				+ "codigo,nome,ano) VALUES(?,?,?)";
		try {
			PreparedStatement stmt = 
			getConexao().prepareStatement(sql);
			stmt.setString(1, c.getCodigo());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getAno());
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		}
	
public List<Jogo> consulta() {
		
		List<Jogo> jogos = new LinkedList<Jogo>();
		String sql = "select * from jogo";
		 try {
			 PreparedStatement stmt = getConexao().prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery();
			 while (rs.next()) {
				 Jogo jogo = new Jogo();
				 jogo.setCodigo(rs.getString("codigo"));
				 jogo.setNome(rs.getString("nome"));
				 jogo.setAno(rs.getString("ano"));
				 jogos.add(jogo);
			}
		 	stmt.close();
		 } catch (SQLException u) {
			 throw new RuntimeException(u);
		 }
		 return jogos;
	}


public void update(Jogo c) {
	String sql = "update jogo set nome=?, ano=? where codigo =?";
	try {
		PreparedStatement stmt = 
		getConexao().prepareStatement(sql);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getAno());
		stmt.setString(3, c.getCodigo());
		stmt.execute();
		stmt.close();
	} catch (SQLException u) {
		throw new RuntimeException(u);
	}
	}

public void remove(Jogo jogo) {
	String sql = "DELETE FROM jogo WHERE codigo = ?";
	try {
		PreparedStatement stmt = 
		getConexao().prepareStatement(sql);
		stmt.setString(1, jogo.getCodigo());
		stmt.execute();
		stmt.close();
	} catch (SQLException u) {
		throw new RuntimeException(u);
	}
	
}

public List<Jogo> pesquisa(String desc) {
	
	List<Jogo> jogos = new LinkedList<Jogo>();
	String sql = "select * from jogo WHERE codigo = ?";
	 try {
		 PreparedStatement stmt = getConexao().prepareStatement(sql);
		 ResultSet rs = stmt.executeQuery();
		 while (rs.next()) {
			 Jogo jogo = new Jogo();
			 jogo.setCodigo(rs.getString("codigo"));
			 jogo.setNome(rs.getString("nome"));
			 jogo.setAno(rs.getString("ano"));
			 jogos.add(jogo);
		}
	 	stmt.close();
	 } catch (SQLException u) {
		 throw new RuntimeException(u);
	 }
	 return jogos;
}

}