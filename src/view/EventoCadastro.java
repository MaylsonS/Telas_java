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
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.time.format.DateTimeParseException;
	import java.awt.event.ActionEvent;
	
	public class EventoCadastro extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField textCadastroEvento;
		private JTextField textFieldDataEvento;
	
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
			setBounds(100, 100, 267, 295);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(10, 11, 233, 236);
			contentPane.add(panel);
			
			JLabel lblCadastroDeEvento = new JLabel("Cadastro De Evento");
			lblCadastroDeEvento.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lblCadastroDeEvento.setBounds(10, 28, 153, 14);
			panel.add(lblCadastroDeEvento);
			
			JLabel lblNewLabel_1 = new JLabel("Titulo do Evento:");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(24, 68, 153, 14);
			panel.add(lblNewLabel_1);
			
			textCadastroEvento = new JTextField();
			textCadastroEvento.setColumns(10);
			textCadastroEvento.setBounds(34, 93, 153, 24);
			panel.add(textCadastroEvento);
			
			JButton btnNewButton = new JButton("Cadastrar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String data = textFieldDataEvento.getText() .trim();
					
					if (textCadastroEvento.getText().trim().isEmpty() || textFieldDataEvento.getText().trim().isEmpty()) {
					    JOptionPane.showMessageDialog(btnNewButton, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
					    return;
						}
						try {
							DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
							LocalDate date = LocalDate.parse(data,dataFormatada);
							
						
							if(date.isBefore(LocalDate.now())) {
								JOptionPane.showMessageDialog(btnNewButton, "Não é possivel cadastrar com uma data menor do que "+LocalDate.now()+" !","Erro", JOptionPane.WARNING_MESSAGE);
								return;
							}
							
							JOptionPane.showMessageDialog(btnNewButton, "Evento Cadastrado!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
					}catch(DateTimeParseException ex) {
						JOptionPane.showMessageDialog(btnNewButton, "Digite a data no Formato DD-MM-AAAA!", "Aviso", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
				}
			});
			btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
			btnNewButton.setBounds(74, 202, 89, 23);
			panel.add(btnNewButton);
			
			JButton btnNewButton_2 = new JButton("Voltar");
			btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
			btnNewButton_2.setBounds(151, 11, 72, 20);
			panel.add(btnNewButton_2);
			
			btnNewButton_2.addActionListener(e->{
				home home = new home();
				home.setLocationRelativeTo(null);
				home.setVisible(true);
			});
			
			JLabel lblNewLabel_2 = new JLabel("------------------------");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_2.setBounds(30, 72, 153, 24);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_1_1 = new JLabel("Data do Evento:");
			lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNewLabel_1_1.setBounds(24, 128, 153, 14);
			panel.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_2_1 = new JLabel("------------------------");
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_2_1.setBounds(25, 130, 153, 24);
			panel.add(lblNewLabel_2_1);
			
			textFieldDataEvento = new JTextField();
			textFieldDataEvento.setColumns(10);
			textFieldDataEvento.setBounds(34, 153, 153, 24);
			panel.add(textFieldDataEvento);
	
		}
	}
