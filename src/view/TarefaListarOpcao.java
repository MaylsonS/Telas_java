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

public class TarefaListarOpcao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TarefaListarOpcao frame = new TarefaListarOpcao();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public TarefaListarOpcao() {
		setTitle("TarefaListarOpcao");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(41, 11, 335, 220);
		contentPane.add(panel);
		
		JLabel lblListagemDeTarefas = new JLabel("Listagem de Tarefas");
		lblListagemDeTarefas.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblListagemDeTarefas.setBounds(64, 56, 217, 18);
		panel.add(lblListagemDeTarefas);
		
		JButton btnTodosOsEventos = new JButton("Todos");
		btnTodosOsEventos.setBounds(10, 119, 80, 29);
		panel.add(btnTodosOsEventos);
		
		btnTodosOsEventos.addActionListener(e->{
			TarefaListar listarTodos = new TarefaListar();
			dispose();
			listarTodos.setLocationRelativeTo(null);
			listarTodos.setVisible(true);
		});
		
		
		JButton btnTarefasCriticas = new JButton("Criticas");
		btnTarefasCriticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TarefaListaCritica criticas = new TarefaListaCritica();
				dispose();
				criticas.setVisible(true);
				criticas.setLocationRelativeTo(null);
				
				
			}
		});
		btnTarefasCriticas.setBounds(122, 119, 95, 29);
		panel.add(btnTarefasCriticas);
		
		JButton btnPorDia = new JButton("Por Dia");
		btnPorDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TarefaListarDia TarefaDia = new TarefaListarDia();
				TarefaDia.setVisible(true);
				TarefaDia.setLocationRelativeTo(null);
			}
		});
		btnPorDia.setBounds(239, 119, 86, 29);
		panel.add(btnPorDia);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione como você deseja filtrar");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(78, 80, 190, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(265, 11, 64, 20);
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(e ->{
			dispose();
			home telaHome = new home(); // Cria a nova janela
			telaHome.setLocationRelativeTo(null); // Centraliza (opcional)
			telaHome.setVisible(true);
		});

	}
}
