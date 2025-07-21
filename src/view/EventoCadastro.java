package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventoCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCadastroEvento;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventoCadastro frame = new EventoCadastro();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public EventoCadastro() {
		setTitle("EventoCadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(20, 11, 252, 193);
		contentPane.add(panel);
		
		JLabel lblCadastroDeEvento = new JLabel("Cadastro De Evento");
		lblCadastroDeEvento.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCadastroDeEvento.setBounds(10, 21, 153, 14);
		panel.add(lblCadastroDeEvento);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo do Evento:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(40, 68, 153, 14);
		panel.add(lblNewLabel_1);
		
		textCadastroEvento = new JTextField();
		textCadastroEvento.setColumns(10);
		textCadastroEvento.setBounds(49, 93, 153, 24);
		panel.add(textCadastroEvento);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textCadastroEvento.getText() != null && !textCadastroEvento.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton, "Evento Castrado!");
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Não foi possivel Cadastrar o Evento!", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(88, 128, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_2.setBounds(180, 0, 72, 20);
		panel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(e->{
			home home = new home();
			home.setLocationRelativeTo(null);
			home.setVisible(true);
		});
		
		JLabel lblNewLabel_2 = new JLabel("------------------------");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(42, 72, 153, 24);
		panel.add(lblNewLabel_2);

	}

}
