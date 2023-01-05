package jdbc;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	
	
	public static void main(String[] args) {
	
		
		
		
		JFrame frame = new JFrame("Gameteca Vasco da Gama");
		frame.setLayout(new FlowLayout());
		
		JPanel pnlCodigo = new JPanel();
		pnlCodigo.add(new JLabel ("Codigo:"));
		JTextField txtCodigo = new JTextField(20);
		pnlCodigo.add(txtCodigo);
		frame.add(pnlCodigo);
		
		JPanel pnlNome = new JPanel();
		pnlNome.add(new JLabel ("  Nome:"));
		JTextField txtNome = new JTextField(20);
		pnlNome.add(txtNome);
		frame.add(pnlNome);
		
		JPanel pnlAno = new JPanel();
		pnlAno.add(new JLabel ("    Ano:"));
		JTextField txtAno = new JTextField(20);
		pnlAno.add(txtAno);
		frame.add(pnlAno);
		
		JButton btnFechar = new JButton ("Fechar");
		frame.add(btnFechar);
		
		JButton btnCadastrar = new JButton ("Cadastrar");
		frame.add(btnCadastrar);
		
		JButton btnListar = new JButton ("Listar");
		frame.add(btnListar);
		
		btnFechar.addActionListener((e) -> System.exit(0));
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameTable frame = new FrameTable();
				frame.setVisible(true); 
				}});
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jogo joguin = new Jogo (txtCodigo.getText(), txtNome.getText(), txtAno.getText());
				JogoDAO jogoDAO = new JogoDAO();
				jogoDAO.adiciona(joguin);
				FrameTable frame = new FrameTable();
				frame.setVisible(true);
			
			}});
			

		
		frame.setSize(350,200);
		frame.setVisible(true);
		
		
		
	}
	
	
	
	
	

}