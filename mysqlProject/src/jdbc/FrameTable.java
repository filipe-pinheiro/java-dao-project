package jdbc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame {
	
	public FrameTable() {
		super("Jogos");
		JogoDAO dao = new JogoDAO();
		JogoTableModel tableModel = new JogoTableModel(dao);
		JTable table = new JTable(tableModel);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		add(scroll);
		JButton btDel = new JButton("Deletar");
		
		btDel.addActionListener( (event) -> {
			String code = JOptionPane.showInputDialog("Insira um código");
			tableModel.delJogo(code);
			dispose();
		});
		
		add(btDel, BorderLayout.SOUTH);
		setSize(600, 360);
	}

}
