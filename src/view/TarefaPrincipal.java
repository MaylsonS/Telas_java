package view;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;
import model.ButtonRenderer;
import model.DataPrazoRender;
import model.ButtonEditor;
import javax.swing.table.DefaultTableModel;


public class TarefaPrincipal extends JFrame{
	private JTextField textFieldDataTarefa;
	private JTextField textFieldDescricaoTarefa;
	private JTextField textFieldPrioridadeTarefa;
	private JTextField textFieldData;
	private JTable table;

    public TarefaPrincipal() {
        setTitle("Sistema de Tarefas com Abas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(690, 5, 80, 20); // posição no topo direito
        getContentPane().add(btnVoltar);
        
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		home home = new home();
        		home.setVisible(true);
        		home.setLocationRelativeTo(null);
        		
        	}
        });
        
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(0, 0, 784, 561);

        // Abas
        tabbedPane.addTab("Listar Tarefas", criarPainelListar());
        tabbedPane.addTab("Cadastrar Tarefas", criarPainelCadastrar());
        tabbedPane.addTab("Subtarefas", criarPainelSubtarefas());
        tabbedPane.addTab("Listar Tarefa Por Dia", painelListarPorDia());
        tabbedPane.addTab("Listar Tarefas Criticas", painelListarCriticas());

        getContentPane().add(tabbedPane);
        setVisible(true);
    }

    // Painel 1 - Listar Tarefas
    private JPanel criarPainelListar() {
        JPanel painelTarefas = new JPanel(new BorderLayout());

        String[] colunas = {"Titulo", "Data", "Descrição", "Status", "Prioridade", "Editar", "Apagar"};
        Object[][] dados = {
        		{"Estudar Java", "23-07-2025", "Descricao", "Pendente", "0", "", ""},
                {"Entregar Projeto", "18-07-2025", "Descricao", "Pendente", "5", "", ""},
                {"Entregar Projeto", "18-09-2025", "Descricao", "Pendente", "5", "", ""}
        };

        JTable tabela = new JTable(dados, colunas);
        painelTarefas.add(new JScrollPane(tabela), BorderLayout.CENTER);
        
        String[] statusOptions = { "Pendente", "Concluída","Atrasada" };
        JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);
        tabela.getColumn("Status").setCellEditor(new DefaultCellEditor(statusComboBox));
        
        tabela.getColumn("Data").setCellRenderer(new DataPrazoRender());
        
     // Botões de Ação nas colunas "Editar" e "Apagar"
        tabela.getColumn("Editar").setCellRenderer(new ButtonRenderer("Editar"));
        tabela.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox(), tabela, "Editar"));

        tabela.getColumn("Apagar").setCellRenderer(new ButtonRenderer("Apagar"));
        tabela.getColumn("Apagar").setCellEditor(new ButtonEditor(new JCheckBox(), tabela, "Apagar"));

        
        return painelTarefas;
    }
 
    // Painel 2 - Cadastrar Tarefas
    private JPanel criarPainelCadastrar() {
        JPanel painelCadastroTarefas = new JPanel();
        painelCadastroTarefas.setLayout(null);

        JLabel lblDigiteOTtulo = new JLabel("Digite o titulo:");
        lblDigiteOTtulo.setBounds(51, 36, 150, 54);
        lblDigiteOTtulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        painelCadastroTarefas.add(lblDigiteOTtulo);
        
        JTextField textFieldTituloTarefa = new JTextField();
        textFieldTituloTarefa.setBounds(188, 51, 384, 28);
        painelCadastroTarefas.add(textFieldTituloTarefa);

        JLabel lblDigiteAData = new JLabel("Digite a data:");
        lblDigiteAData.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDigiteAData.setBounds(51, 101, 150, 81);
        painelCadastroTarefas.add(lblDigiteAData);

        JLabel lblDigiteADescrio = new JLabel("Digite a descrição da tarefa:");
        lblDigiteADescrio.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDigiteADescrio.setBounds(51, 193, 285, 91);
        painelCadastroTarefas.add(lblDigiteADescrio);

        JLabel lblDigiteAPrioridade = new JLabel("Digite a prioridade da tarefa:");
        lblDigiteAPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblDigiteAPrioridade.setBounds(51, 295, 275, 91);
        painelCadastroTarefas.add(lblDigiteAPrioridade);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(274, 431, 160, 40);
        painelCadastroTarefas.add(btnSalvar);
        
        
        btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = textFieldTituloTarefa.getText().trim();
				String data = textFieldDataTarefa.getText().trim();
				String prioridadeTexto = textFieldPrioridadeTarefa.getText().trim();
				
				if(titulo.isEmpty() || titulo.equalsIgnoreCase(" ") || data.isEmpty() || data.equalsIgnoreCase(" ") ||
						prioridadeTexto.isEmpty() || prioridadeTexto.equalsIgnoreCase(" ") ) {
					
					JOptionPane.showMessageDialog(btnSalvar,"Preencha todos os campos obrigatorios!\n Titulo, Data e Prioridade",
							"Avisos",JOptionPane.WARNING_MESSAGE);
					return;
				}
				try {
					DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					
					LocalDate date = LocalDate.parse(data,dataFormatada);
					
					if (date.isBefore(LocalDate.now())) {
				        JOptionPane.showMessageDialog(btnSalvar, 
				            "Não é possível cadastrar uma tarefa com uma data no passado.",
				            "Data inválida", 
				            JOptionPane.WARNING_MESSAGE);
				        return;
				    }
					
				}catch(DateTimeParseException ex) {
					JOptionPane.showMessageDialog(btnSalvar, "A data precisa esta no formato DD-MM-YYYY", "Formato Invalido",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				try {
					int prioridade = Integer.parseInt(prioridadeTexto);
					
					if(prioridade < 0 || prioridade > 5) {
						JOptionPane.showMessageDialog(btnSalvar, "A Prioridade deve ser entre 0 e 5.", "Aviso", JOptionPane.WARNING_MESSAGE);
						return;
						
					}
					JOptionPane.showMessageDialog(btnSalvar, "Tarefa Salva.", "Concluido", JOptionPane.INFORMATION_MESSAGE);
				
				} 
				catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(btnSalvar, 
							"A prioridade deve ser um número inteiro.",
							"Erro de Formato",
							JOptionPane.ERROR_MESSAGE);
					}
				
			}
			
		});
        MaskFormatter mascaraData = null;
		try {
		    mascaraData = new MaskFormatter("##-##-####"); // AAAA-MM-DD
		    mascaraData.setPlaceholderCharacter('_');
		} catch (java.text.ParseException e1) {
		    e1.printStackTrace(); 
		}
        textFieldDataTarefa = new JFormattedTextField(mascaraData);
        textFieldDataTarefa.setBounds(188, 129, 197, 28);
        painelCadastroTarefas.add(textFieldDataTarefa);
        
        textFieldDescricaoTarefa = new JTextField();
        textFieldDescricaoTarefa.setBounds(274, 226, 384, 28);
        painelCadastroTarefas.add(textFieldDescricaoTarefa);
        
        textFieldPrioridadeTarefa = new JTextField();
        textFieldPrioridadeTarefa.setBounds(274, 328, 384, 28);
        painelCadastroTarefas.add(textFieldPrioridadeTarefa);

        return painelCadastroTarefas;
    }

    // Painel 3 - Subtarefas
    private JPanel criarPainelSubtarefas() {
    	
        JPanel painelSubtarefas = new JPanel(new BorderLayout());
        
        
        JTabbedPane abasInternas = new JTabbedPane();
        
        JPanel painelCadastro = new JPanel();
        painelCadastro.setLayout(null);
        
        JLabel labelTarefaMae = new JLabel("Selecione a Tarefa: ");
        labelTarefaMae.setBounds(50,50,200,25);
        painelCadastro.add(labelTarefaMae);
        
        JTextField textTarefaMae = new JTextField();
        textTarefaMae.setBounds(200,50,300,25);
        painelCadastro.add(textTarefaMae);
        
        
        JLabel labelTitulo = new JLabel("Titulo da Subtarefa");
        labelTitulo.setBounds(50,90,200,25);
        painelCadastro.add(labelTitulo);
        
        JTextField textTitulo = new JTextField();
        textTitulo.setBounds(200,90,300,25);
        painelCadastro.add(textTitulo);
        
        JLabel labelDescricao = new JLabel("Descrição:");
        labelDescricao .setBounds(50, 130, 200, 25);
        painelCadastro.add(labelDescricao);
        
        JTextField textDescricao = new JTextField();
        textDescricao.setBounds(200, 130, 300, 25);
        painelCadastro.add(textDescricao);
        
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(!textTitulo.getText().isEmpty()) {
        			JOptionPane.showMessageDialog(btnSalvar, "Subtarefa Salva Com Sucesso", "SubTarefa Salva",JOptionPane.INFORMATION_MESSAGE);
        			return ;
        		}	else{
        			JOptionPane.showMessageDialog(btnSalvar, "É preciso adicionar um titulo a SubTarefa", "Erro",JOptionPane.WARNING_MESSAGE);
        			return;
        		}
        	}
        });
        btnSalvar.setBounds(250, 180, 100, 30);
        painelCadastro.add(btnSalvar);
        
                
        JPanel painelListagem = new JPanel(new BorderLayout());
        
        String[] colunas = {  "Titulo", "Data", "Descrição", "Status", "Prioridade", "Editar", "Apagar" };
        Object[][] linhas = {
        		{"Estudar Java", "23-07-2025", "Descricao", "Pendente", "0", "", ""},
                {"Entregar Projeto", "18-07-2025", "Descricao", "Pendente", "5", "", ""}
        };


        
        JTable tabela = new JTable(linhas, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);
        painelListagem.add(scrollPane, BorderLayout.CENTER);
        
        String[] statusOptions = { "Pendente", "Concluída","Atrasada" };
        JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);
        tabela.getColumn("Status").setCellEditor(new DefaultCellEditor(statusComboBox));
        
        tabela.getColumn("Data").setCellRenderer(new DataPrazoRender());
        
        // Botões de Ação nas colunas "Editar" e "Apagar"
        tabela.getColumn("Editar").setCellRenderer(new ButtonRenderer("Editar"));
        tabela.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox(), tabela, "Editar"));

        tabela.getColumn("Apagar").setCellRenderer(new ButtonRenderer("Apagar"));
        tabela.getColumn("Apagar").setCellEditor(new ButtonEditor(new JCheckBox(), tabela, "Apagar"));
        
        JComboBox comboBoxTarefaMae = new JComboBox();
        comboBoxTarefaMae.setBounds(200, 287, 300, 25);
        
        painelCadastro.add(comboBoxTarefaMae);
        abasInternas.addTab("Listar", painelListagem);
        abasInternas.addTab("Cadastrar", painelCadastro);

        painelSubtarefas.add(abasInternas, BorderLayout.CENTER);
        return painelSubtarefas;
        
        
    }
    
    private JPanel painelListarPorDia(){
    	JPanel painelListarPDia = new JPanel();
    	painelListarPDia.setLayout(null);
    	
    	
    	textFieldData = new JTextField();
    	textFieldData.setBounds(320, 21, 136, 25);
    	textFieldData.setFont(new Font("Tahoma", Font.BOLD, 15));
    	painelListarPDia.add(textFieldData);
    	textFieldData.setColumns(10);
    	
    	JButton btnBuscar = new JButton("Buscar");
    	btnBuscar.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			if(textFieldData.getText().isEmpty()) {
    				JOptionPane.showMessageDialog(btnBuscar, "Digite a data","Erro", JOptionPane.WARNING_MESSAGE);
    			}
    		}
    	});
    	btnBuscar.setBounds(350, 62, 90, 23);
    	painelListarPDia.add(btnBuscar);
    	
    	JLabel labelData = new JLabel("DD-MM-YYYY");
    	labelData.setBounds(320, 47, 70, 13);
    	labelData.setFont(new Font("Tahoma", Font.BOLD, 10));
    	painelListarPDia.add(labelData);
    
    	
    	 String[] colunas = {"Titulo", "Data", "Descrição", "Status", "Prioridade", "Editar", "Apagar"};
         Object[][] dados = {
         		{"Estudar Java", "23-07-2025", "Descricao", "Pendente", "0", "", ""},
                 {"Entregar Projeto", "18-07-2025", "Descricao", "Pendente", "5", "", ""},
                 {"Entregar Projeto", "18-09-2025", "Descricao", "Pendente", "5", "", ""}
         };
         
         JTable tabela = new JTable(dados, colunas);
         JScrollPane scrollPane = new JScrollPane(tabela);
         scrollPane.setBounds(10,102,759,427);
         painelListarPDia.add(scrollPane);
         
         
         String[] statusOptions = { "Pendente", "Concluída","Atrasada" };
         JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);
         
         tabela.getColumn("Status").setCellEditor(new DefaultCellEditor(statusComboBox));
         
         tabela.getColumn("Data").setCellRenderer(new DataPrazoRender());
         
         // Botões de Ação nas colunas "Editar" e "Apagar"
         tabela.getColumn("Editar").setCellRenderer(new ButtonRenderer("Editar"));
         tabela.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox(), tabela, "Editar"));

         tabela.getColumn("Apagar").setCellRenderer(new ButtonRenderer("Apagar"));
         tabela.getColumn("Apagar").setCellEditor(new ButtonEditor(new JCheckBox(), tabela, "Apagar"));
         
         JLabel lblListaDeTarefas = new JLabel("Lista de Tarefas Por Dia");
         lblListaDeTarefas.setFont(new Font("Tahoma", Font.BOLD, 18));
         lblListaDeTarefas.setBounds(10, 11, 246, 22);
         painelListarPDia.add(lblListaDeTarefas);
         
    	return painelListarPDia;
    }
    
    private JPanel painelListarCriticas() {
    	JPanel painelListarCriticas = new JPanel();
    	
    	
    	String[] colunas = {"Titulo", "Data", "Descrição", "Status", "Prioridade", "Editar", "Apagar"};
        Object[][] dados = {
        		{"Estudar Java", "23-07-2025", "Descricao", "Pendente", "0", "", ""},
                {"Entregar Projeto", "18-07-2025", "Descricao", "Pendente", "5", "", ""},
                {"Entregar Projeto", "18-09-2025", "Descricao", "Pendente", "5", "", ""}
        };
        painelListarCriticas.setLayout(null);

        JTable tabela = new JTable(dados, colunas);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(10, 77, 759, 427);
        painelListarCriticas.add(scrollPane);
        
        String[] statusOptions = { "Pendente", "Concluída","Atrasada" };
        JComboBox<String> statusComboBox = new JComboBox<>(statusOptions);
        tabela.getColumn("Status").setCellEditor(new DefaultCellEditor(statusComboBox));
        
        tabela.getColumn("Data").setCellRenderer(new DataPrazoRender());
        
     // Botões de Ação nas colunas "Editar" e "Apagar"
        tabela.getColumn("Editar").setCellRenderer(new ButtonRenderer("Editar"));
        tabela.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox(), tabela, "Editar"));

        tabela.getColumn("Apagar").setCellRenderer(new ButtonRenderer("Apagar"));
        tabela.getColumn("Apagar").setCellEditor(new ButtonEditor(new JCheckBox(), tabela, "Apagar"));
        
        JLabel lblNewLabel = new JLabel("Listagem de Tarefas Criticas");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 11, 247, 28);
        painelListarCriticas.add(lblNewLabel);

    	
    	return painelListarCriticas;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TarefaPrincipal::new);
    }
}
