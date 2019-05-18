package com.nipsters.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

public class TelaCadastroPessoa extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtFuncao;
	private JTextField txtSetor;
	private JFormattedTextField txtDataNascimento;
	ButtonGroup bg=new ButtonGroup();

	public TelaCadastroPessoa() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		setSize(580,430);
		PainelCadastro();
	}
	private void PainelCadastro() {
		//Adicionando os Labels
		JLabel lblNome = new JLabel("Nome*");
		lblNome.setBounds(26, 28, 82, 14);
		add(lblNome);
		txtNome = new JTextField();
		txtNome.setBounds(37, 50, 480, 20);
		add(txtNome);
		txtNome.setColumns(10);
		JLabel lblFuncao = new JLabel("Função*");
		lblFuncao.setBounds(26, 81, 100, 14);
		add(lblFuncao);
		txtFuncao = new JTextField();
		txtFuncao.setBounds(37, 104, 480, 20);
		txtFuncao.setColumns(10);
		add(txtFuncao);
		JLabel lblDataNasc = new JLabel("Data Nasc.*");
		lblDataNasc.setBounds(27, 185, 99, 14);
		add(lblDataNasc);
		JLabel lblSetor = new JLabel("Setor*");
		lblSetor.setBounds(26, 135, 56, 14);
		add(lblSetor);
		txtSetor = new JTextField();
		txtSetor.setBounds(37, 154, 480, 20);
		txtSetor.setColumns(10);
		add(txtSetor);
		JLabel lblGenero = new JLabel("Gênero*");
		lblGenero.setBounds(279, 185, 82, 14);
		add(lblGenero);
		JLabel lblcamposMarcadosCom = new JLabel("(Campos marcados com * são obrigatórios)");
		lblcamposMarcadosCom.setBounds(36, 352, 264, 14);
		add(lblcamposMarcadosCom);
		//Criar Botões de gênero
		JRadioButton GeneroMasculino = new JRadioButton("Masculino",true);

		GeneroMasculino.setBounds(279, 206, 109, 23);
		GeneroMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(GeneroMasculino);	
		JRadioButton GeneroFeminino = new JRadioButton("Feminino");
		GeneroFeminino.setBounds(279, 232, 100, 23);
		GeneroFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(GeneroFeminino);
		//ativar ActionListener de botões de gênero
		bg.add(GeneroFeminino);
		bg.add(GeneroMasculino);
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCadastrar.setBounds(461, 395, 109, 23);
		add(btnCadastrar);

		//criar máscara de data
		try {
			txtDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txtDataNascimento.setBounds(37, 206, 71, 20);
			add(txtDataNascimento);


		} catch (ParseException e) {
			System.err.println("ERRO: TelaCadastrarCliente -> MaskFormatter");
		}
	}
}


