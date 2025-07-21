package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import model.ButtonRenderer;
import model.ButtonEditor;

import javax.swing.JScrollPane;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import java.awt.Color;

public class TarefaListar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarefaListar frame = new TarefaListar();
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
	public TarefaListar() {
		setBackground(new Color(255, 0, 255));
		setTitle("TarefaListar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lista de Tarefas");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 42, 145, 20);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 530, 190);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][]
					{
			},
			new String[] {
				"Titulo", "Data","Descrição" ,"Status","Prioridade","Editar", "Apagar"
			}
			
		));	
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { "Estudar Java", "2025-07-20", "Descricao do negocio", "Pendente", "0" });
		model.addRow(new Object[] { "Entregar Projeto", "2025-07-22", "Descricao do negocio", "Pendente", "5" });

		
		table.getColumn("Editar").setCellRenderer(new ButtonRenderer("Editar"));
		table.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox(), table, "Editar"));

		// Renderizador e editor para o botão "Apagar"
		table.getColumn("Apagar").setCellRenderer(new ButtonRenderer("Apagar"));
		table.getColumn("Apagar").setCellEditor(new ButtonEditor(new JCheckBox(), table, "Apagar"));
		
		// Criar o JComboBox com os status possíveis
		String[] statusOptions = { "Pendente", "Concluída" };
		JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);

		// Definir o editor da célula para a coluna "Status"
		table.getColumn("Status").setCellEditor(new DefaultCellEditor(statusComboBox));

		
		btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(468, 11, 72, 20);
		contentPane.add(btnNewButton);
		
		
		btnNewButton.addActionListener(e->{
			dispose();
			TarefaListarOpcao tarefaListar = new TarefaListarOpcao();
			tarefaListar.setLocationRelativeTo(null);
			tarefaListar.setVisible(true);
		});


	}
}
