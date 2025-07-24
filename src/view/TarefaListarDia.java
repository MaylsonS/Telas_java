package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TarefaListarDia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldData;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarefaListarDia frame = new TarefaListarDia();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TarefaListarDia() {
		setTitle("TarefaListarDia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 475, 270);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar as Tarefas do Dia");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 274, 25);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(82, 47, 88, 23);
		panel.add(btnNewButton);
		
		textFieldData = new JTextField();
		textFieldData.setBounds(180, 47, 146, 22);
		panel.add(textFieldData);
		textFieldData.setColumns(10);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 81, 411, 180);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titulo", "Data", "Status", "Editar", "Apagar"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("AAAA-MM-DD");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 8));
		lblNewLabel_1.setBounds(196, 35, 88, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TarefaListarOpcao TarefaLista = new TarefaListarOpcao();
				TarefaLista.setVisible(true);
				TarefaLista.setLocationRelativeTo(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 8));
		btnNewButton_2.setBounds(378, 11, 55, 20);
		panel.add(btnNewButton_2);

	}
}
