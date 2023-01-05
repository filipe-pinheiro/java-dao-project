package jdbc;

import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class JogoTableModel extends AbstractTableModel implements TableModelListener{
	
	JogoDAO dao;
	List<Jogo> jogos;
	List<String> colunas;
	
	public JogoTableModel(JogoDAO dao) {
		this.dao = dao;
		jogos = dao.consulta();
		colunas = List.of("Codigo", "Nome", "Ano");
		this.addTableModelListener(this);
	}

	@Override
	public int getRowCount() {
		return jogos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Jogo jogo = jogos.get(rowIndex);
		switch (columnIndex) {
		case 0: return jogo.getCodigo();
		case 1: return jogo.getNome();
		case 2: return jogo.getAno();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return colunas.get(column);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Jogo jogo = jogos.get(rowIndex);
		switch (columnIndex) {
		case 0: 
			jogo.setCodigo((String)aValue);
			break;
		case 1:
			jogo.setNome((String)aValue);
			break;
		case 2:
			jogo.setAno((String)aValue);
			break;
		}
		
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int i = e.getFirstRow();
		Jogo jogo = jogos.get(i);
		dao.update(jogo);
		
	}

	public void delJogo(String code) {
		Jogo jogo = new Jogo();
		jogo.setCodigo(code);		
		dao.remove(jogo);
		fireTableDataChanged();
		
	}
	
	public void search(String x) {
		Jogo jogo = new Jogo();
		jogo.setCodigo(x);
		dao.pesquisa(x);
	}

}
