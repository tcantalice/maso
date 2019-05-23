package com.nipsters.view;

import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class TelaCadastroAtestado extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txtNumero;
	private JTextField txtData;
	private JTextField txtNome;
	private JTextField txtTipo;

	public TelaCadastroAtestado() {

		setSize(600,500);
		setLayout(null);

		CadastroAtestado();

	}	

	private void CadastroAtestado() {
		JLabel lblNmero = new JLabel("Número de atestado*");
		lblNmero.setBounds(60, 60, 154, 14);
		add(lblNmero);
		
		JLabel lblcamposMarcadosCom = new JLabel("(Campos marcados com * são obrigatórios)");
		lblcamposMarcadosCom.setBounds(36, 352, 264, 14);
		add(lblcamposMarcadosCom);

		txtNumero = new JTextField();
		txtNumero.setBounds(60, 79, 281, 20);
		add(txtNumero);
		txtNumero.setColumns(10);

		JLabel lblData = new JLabel("Data*");
		lblData.setBounds(405, 60, 46, 14);
		add(lblData);

		JLabel lblNomeopcional = new JLabel("Nome");
		lblNomeopcional.setBounds(60, 142, 114, 14);
		add(lblNomeopcional);

		txtNome = new JTextField();
		txtNome.setBounds(60, 167, 484, 20);
		add(txtNome);
		txtNome.setColumns(10);

		JLabel lblTipoDeAtestado = new JLabel("Tipo de atestado*");
		lblTipoDeAtestado.setBounds(60, 226, 114, 14);
		add(lblTipoDeAtestado);

		txtTipo = new JTextField();
		txtTipo.setBounds(60, 251, 484, 20);
		add(txtTipo);
		txtTipo.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(461, 395, 109, 23);
		add(btnCadastrar);
		//Máscara de data
		try {
			txtData = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txtData.setBounds(405, 79, 69, 20);
			add(txtData);
		} catch (ParseException e) {
			System.err.println("ERRO: TelaCadastrarCliente -> MaskFormatter");
		}
	}
}



