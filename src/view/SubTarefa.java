package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubTarefa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubTarefa frame = new SubTarefa();
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
	public SubTarefa() {
		setTitle("SubTarefa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 11, 281, 189);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SubTarefa");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(75, 39, 130, 44);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(10, 94, 108, 50);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(e->{
			dispose();
			SubtarefaCadastro cadastro = new SubtarefaCadastro();
			cadastro.setLocationRelativeTo(null);
			cadastro.setVisible(true);
			
			
			
		});
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
