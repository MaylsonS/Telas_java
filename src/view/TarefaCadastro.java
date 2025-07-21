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
import java.text.DateFormat;
import java.text.ParseException;
import java.awt.event.ActionEvent;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class TarefaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCadastrar;
	private JTextField textField;
	private JFormattedTextField textFieldData;
	private JTextField textFieldPrioridade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarefaCadastro frame = new TarefaCadastro();
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
	public TarefaCadastro() {
		setTitle("TarefaCadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 264, 335);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro De Tarefas");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 13, 153, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo da Tarefa :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(35, 38, 153, 14);
		panel.add(lblNewLabel_1);
		
		textFieldCadastrar = new JTextField();
		textFieldCadastrar.setBounds(35, 60, 174, 24);
		panel.add(textFieldCadastrar);
		textFieldCadastrar.setColumns(10);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		//Adicionando ação no botão;
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = textFieldCadastrar.getText().trim();
				String data = textFieldData.getText().trim() ;
				String prioridadeTexto = textFieldPrioridade.getText().trim();
				
				if(titulo.isEmpty() || titulo.equalsIgnoreCase(" ") || data.isEmpty() || data.equalsIgnoreCase(" ") ||
						prioridadeTexto.isEmpty() || prioridadeTexto.equalsIgnoreCase(" ") ) {
					
					JOptionPane.showMessageDialog(btnNewButton,"Preencha todos os campos obrigatorios!",
							"Avisos",JOptionPane.WARNING_MESSAGE);
					return;
				}
				try {
					DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					
					LocalDate date = LocalDate.parse(data,dataFormatada);
					
				}catch(DateTimeParseException ex) {
					JOptionPane.showMessageDialog(btnNewButton, "A data precisa esta no formato AAAA-MM-DD aaaaaa", "Formato Invalido",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				
				try {
					int prioridade = Integer.parseInt(prioridadeTexto);
					
					if(prioridade < 0 || prioridade > 5) {
						JOptionPane.showMessageDialog(btnNewButton, "A Prioridade deve ser entre 0 e 5.", "Aviso", JOptionPane.WARNING_MESSAGE);
						return;
						
					}
					JOptionPane.showMessageDialog(btnNewButton, "Tarefa Salva.", "Concluido", JOptionPane.INFORMATION_MESSAGE);
				
				} 
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnNewButton, 
							"A prioridade deve ser um número inteiro.",
							"Erro de Formato",
							JOptionPane.ERROR_MESSAGE);
					}
				
			}
			
		});
		btnNewButton.setBounds(79, 301, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_2.setBounds(182, 0, 72, 20);
		panel.add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(e->{
			dispose();
			Tarefa tarefa = new Tarefa();
			tarefa.setLocationRelativeTo(null);
			tarefa.setVisible(true);
		});
		
		JLabel lblNewLabel_2 = new JLabel("------------------------");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(36, 40, 153, 24);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descrição da Tarefa");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(35, 95, 153, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("-----------------------------");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1.setBounds(35, 97, 153, 24);
		panel.add(lblNewLabel_2_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(35, 116, 174, 24);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Data de Conclusão");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(36, 151, 153, 14);
		panel.add(lblNewLabel_1_1_1);
		
		MaskFormatter mascaraData = null;
		try {
		    mascaraData = new MaskFormatter("##-##-####"); // AAAA-MM-DD
		    mascaraData.setPlaceholderCharacter('_');
		} catch (java.text.ParseException e1) {
		    e1.printStackTrace(); 
		}

		textFieldData = new JFormattedTextField(mascaraData); // <-- correção: sem "JFormattedTextField" na frente
		textFieldData.setBounds(35, 173, 174, 24);
		panel.add(textFieldData);

		
		JLabel lblNewLabel_1_2 = new JLabel("DD-MM-AAAA");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_1_2.setBounds(35, 198, 89, 14);
		panel.add(lblNewLabel_1_2);
		
		textFieldPrioridade = new JTextField();
		textFieldPrioridade.setColumns(10);
		textFieldPrioridade.setBounds(35, 247, 174, 24);
		panel.add(textFieldPrioridade);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Prioridade");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1_1_1.setBounds(35, 222, 153, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("-----------------");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2_1_1_1.setBounds(35, 224, 153, 24);
		panel.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("A priprodade vai de 0 (Fácil) 5 (Dificil)");
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNewLabel_1_2_1.setBounds(35, 270, 174, 14);
		panel.add(lblNewLabel_1_2_1);

	}
}
