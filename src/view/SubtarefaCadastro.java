package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SubtarefaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textTarefa;
	private JTextField textSubtarefa;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubtarefaCadastro frame = new SubtarefaCadastro();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SubtarefaCadastro() {
		setTitle("SubtarefaCadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 254);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 256, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCadastroDeSubtarefa = new JLabel("Cadastro De SubTarefa");
		lblCadastroDeSubtarefa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCadastroDeSubtarefa.setBounds(10, 34, 168, 14);
		panel.add(lblCadastroDeSubtarefa);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_2.setBounds(189, 11, 64, 20);
		panel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(e->{
			SubTarefa subtarefa = new SubTarefa();
			dispose();
			subtarefa.setLocationRelativeTo(null);
			subtarefa.setVisible(true);
		});
		
		JLabel lblNewLabel_1 = new JLabel("Titulo da Tarefa :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(50, 70, 153, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("------------------------");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(50, 72, 153, 24);
		panel.add(lblNewLabel_2);
		
		textTarefa = new JTextField();
		textTarefa.setColumns(10);
		textTarefa.setBounds(50, 91, 153, 18);
		panel.add(textTarefa);
		
		JLabel lblNewLabel_1_1 = new JLabel("Titulo da SubTarefa :");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(50, 120, 154, 14);
		panel.add(lblNewLabel_1_1);
		
		textSubtarefa = new JTextField();
		textSubtarefa.setColumns(10);
		textSubtarefa.setBounds(50, 137, 153, 18);
		panel.add(textSubtarefa);
		
		JLabel lblNewLabel_2_1 = new JLabel("------------------------");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(50, 122, 153, 24);
		panel.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Cadastrar");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textTarefa.getText() != null && !textTarefa.getText().isEmpty()
						&& textSubtarefa.getText() != null && !textSubtarefa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton, "SubTarefa Cadastrada !");
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Não foi possivel Cadastrar a SubTarefa !", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBounds(77, 166, 89, 23);
		panel.add(btnNewButton);

	}

}
