package com.nipsters.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.nipsters.commons.exceptions.ColaboradorNaoExistenteException;
import com.nipsters.controller.SearchController;

public class TelaBusca extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable TabelaNome;
	private JTextField txtNumeroAtestado;
	private JTable TabelaAtestado;
	private JTextField txtNome;

	public TelaBusca() {
		setSize(600, 500);
		setLayout(null);
		// Criar Painel superior que contém botões de busca/volta e combobox
		JPanel PainelSuperior = new JPanel();
		PainelSuperior.setBounds(10, 11, 580, 82);
		add(PainelSuperior);
		PainelSuperior.setLayout(null);

		JLabel lblBuscarPor = new JLabel("Buscar por: ");
		lblBuscarPor.setBounds(28, 11, 70, 14);
		PainelSuperior.add(lblBuscarPor);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 69, 580, 2);
		PainelSuperior.add(separator);
		// Criar comboBox
		JComboBox<String> Combo1 = new JComboBox<String>();
		Combo1.setModel(new DefaultComboBoxModel<String>(new String[] { "Nome", "Atestado" }));
		Combo1.setBounds(96, 8, 86, 20);
		PainelSuperior.add(Combo1);

		// Criar painel de busca por numero de atestado
		JPanel PainelBuscaAtestado = new JPanel();
		PainelBuscaAtestado.setBounds(10, 104, 580, 350);
		add(PainelBuscaAtestado);
		PainelBuscaAtestado.setVisible(false);
		PainelBuscaAtestado.setLayout(null);

		JLabel lblNmeroDoAtestado = new JLabel("Número do atestado");
		lblNmeroDoAtestado.setBounds(10, 11, 136, 14);
		PainelBuscaAtestado.add(lblNmeroDoAtestado);

		txtNumeroAtestado = new JTextField();
		txtNumeroAtestado.setBounds(10, 36, 256, 20);
		PainelBuscaAtestado.add(txtNumeroAtestado);
		txtNumeroAtestado.setColumns(10);

		JScrollPane ScrollAtestado = new JScrollPane();
		ScrollAtestado.setBounds(10, 120, 560, 131);
		PainelBuscaAtestado.add(ScrollAtestado);

		TabelaAtestado = new JTable();
		TabelaAtestado.setModel(new DefaultTableModel(new Object[][] {
				{ "1Informações", "Do", "Atestado", "Pesquisado" }, { "2Informações", "Do", "Atestado", "Pesquisado" },
				{ "3Informações", "Do", "Atestado", "Pesquisado" }, { "4Informações", "Do", "Atestado", "Pesquisado" },
				{ "5Informações", "Do", "Atestado", "Pesquisado" },
				{ "6Informações", "Do", "Atestado", "Pesquisado" }, },
				new String[] { "N\u00FAmero", "Data", "Tipo de atestado" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TabelaAtestado.getColumnModel().getColumn(0).setPreferredWidth(104);
		TabelaAtestado.getColumnModel().getColumn(2).setPreferredWidth(256);
		ScrollAtestado.setViewportView(TabelaAtestado);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(276, 35, 109, 23);
		PainelBuscaAtestado.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		// Criar painel de busca por nome
		JPanel PainelBuscaNome = new JPanel();
		PainelBuscaNome.setBounds(10, 95, 580, 360);
		add(PainelBuscaNome);
		PainelBuscaNome.setVisible(false);
		PainelBuscaNome.setLayout(null);

		JScrollPane ScrollNome = new JScrollPane();
		ScrollNome.setBounds(10, 63, 560, 262);

		PainelBuscaNome.add(ScrollNome);
		// criar tabela para mostrar os dados
		TabelaNome = new JTable();
		TabelaNome.setModel(new DefaultTableModel(new Object[][] { { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, { "Informações", "Do", "Usuário", "Pesquisado" },
				{ "Informações", "Do", "Usuário", "Pesquisado" }, },
				new String[] { "Nome", "Data", "Atestado", "N\u00FAmero" }) {
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TabelaNome.getColumnModel().getColumn(0).setPreferredWidth(166);
		TabelaNome.getColumnModel().getColumn(2).setPreferredWidth(291);
		ScrollNome.setViewportView(TabelaNome);

		txtNome = new JTextField();
		txtNome.setBounds(10, 25, 437, 20);
		PainelBuscaNome.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 0, 46, 14);
		PainelBuscaNome.add(lblNome);

		JButton button = new JButton("Buscar");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try{
					SearchController.searchCollaborator(txtNome.getText());
				}catch(ColaboradorNaoExistenteException cnee){
					JOptionPane.showMessageDialog(null, cnee.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
				}catch(IllegalArgumentException iae){
					JOptionPane.showMessageDialog(null, iae.getMessage(), "Falha", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		button.setBounds(461, 24, 109, 23);
		PainelBuscaNome.add(button);
		//Ações do ComboBox
		Combo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Combo1.getSelectedIndex()==0) {
					PainelBuscaAtestado.setVisible(false);
					PainelBuscaNome.setVisible(true);
				}else {
					PainelBuscaNome.setVisible(false);
					PainelBuscaAtestado.setVisible(true);
				}
			}
		});
	}
}
