package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Tarefa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tarefa frame = new Tarefa();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Tarefa() {
		setTitle("Tarefa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 325, 199);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tarefa");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(119, 58, 92, 23);
		panel.add(lblNewLabel);
		
		
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
		btnNewButton_2.addActionListener(e ->{
			dispose();
			home telaHome = new home(); // Cria a nova janela
			telaHome.setLocationRelativeTo(null); // Centraliza (opcional)
			telaHome.setVisible(true);
			});
		
		btnNewButton_2.setBounds(253, 11, 72, 20);
		panel.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_3 = new JButton("Cadastrar");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_3.setBounds(31, 104, 108, 50);
		panel.add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(e->{
			dispose();
			TarefaCadastro cadastro = new TarefaCadastro();
			cadastro.setLocationRelativeTo(null);
			cadastro.setVisible(true);
		});
		
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnListar.setBounds(186, 104, 108, 50);
		panel.add(btnListar);
		
		btnListar.addActionListener(e->{
			dispose();
			TarefaListarOpcao listar = new TarefaListarOpcao();
			listar.setLocationRelativeTo(null);
			listar.setVisible(true);
		});

	}

}
