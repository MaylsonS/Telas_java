package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Evento extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Evento frame = new Evento();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Evento() {
		setTitle("Evento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(34, 11, 281, 189);
		contentPane.add(panel);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblEvento.setBounds(99, 41, 108, 43);
		panel.add(lblEvento);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 94, 108, 50);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(e->{
			dispose();
			EventoCadastro cadastroEvento = new EventoCadastro();
			cadastroEvento.setLocationRelativeTo(null);
			cadastroEvento.setVisible(true);
			
			
		});
		
		
		JButton btnListar = new JButton("Listar");
		btnListar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnListar.setBounds(163, 94, 108, 50);
		panel.add(btnListar);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_2.setBounds(209, 11, 72, 20);
		panel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(e ->{
			dispose();
			home telaHome = new home(); // Cria a nova janela
			telaHome.setLocationRelativeTo(null); // Centraliza (opcional)
			telaHome.setVisible(true);
		});

	}

}
