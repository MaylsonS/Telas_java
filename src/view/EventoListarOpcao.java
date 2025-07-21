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

public class EventoListarOpcao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventoListarOpcao frame = new EventoListarOpcao();
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
	public EventoListarOpcao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(42, 29, 335, 220);
		contentPane.add(panel);
		
		JLabel lblListagemDeEventos = new JLabel("Listagem de Eventos");
		lblListagemDeEventos.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblListagemDeEventos.setBounds(64, 56, 217, 18);
		panel.add(lblListagemDeEventos);
		
		JButton btnTodosOsEventos = new JButton("Todos");
		btnTodosOsEventos.setBounds(10, 105, 80, 29);
		panel.add(btnTodosOsEventos);
		
		JButton btnPorDias = new JButton("Por Dias");
		btnPorDias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPorDias.setBounds(123, 105, 95, 29);
		panel.add(btnPorDias);
		
		JButton btnPorMes = new JButton("Por Mes");
		btnPorMes.setBounds(245, 105, 86, 29);
		panel.add(btnPorMes);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione como você deseja filtrar");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(78, 80, 190, 14);
		panel.add(lblNewLabel_1);

	}

}
