package com.nipsters.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	 @SuppressWarnings("deprecation")
	public static void main(String args[]) { 
		 
	     try {  
	        
	       UIManager.put("Synthetica.window.decoration", Boolean.FALSE);   
	       UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());  
	       (new TelaPrincipal()).show();  
	     } catch (Exception erro) {  
	       erro.printStackTrace();  
	     }  
	   }
	public TelaPrincipal() {
	
		
		
		
		
		//========================================================
		setBounds(650, 275, 600, 600);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600,500);
		setTitle("Sistema ASO");
		setResizable(false);
		
		
		//Criar a barra de menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnInicio = new JMenu("Inicio");
		JMenuItem mntmTelaInicial = new JMenuItem("Menu Inicial");
		mntmTelaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new PainelTelaInicio());
				setTitle("Sistema ASO");
				setVisible(true);
			}
		});
		mnInicio.add(mntmTelaInicial);
		menuBar.add(mnInicio);

		//Criar botão de criação no menu
		JMenu mnCriar = new JMenu("Criar");
		menuBar.add(mnCriar);
		//Cadastro de novo colaborador
		JMenuItem mntmNovoCadastro = new JMenuItem("Novo cadastro");
		mntmNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new TelaCadastroPessoa());
				setTitle("Cadastro Colaborador");
				setVisible(true);
			}
		});
		mnCriar.add(mntmNovoCadastro);
		//Cadastro de novo atestado
		JMenuItem mntmNovoAtestado = new JMenuItem("Novo atestado");
		mntmNovoAtestado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new TelaCadastroAtestado());
				setTitle("Cadastro Atestado");
				setVisible(true);
			}
		});
		mnCriar.add(mntmNovoAtestado);
		//Criar botão de busca no menu
		JMenu mnBuscar = new JMenu("Buscar");
		menuBar.add(mnBuscar);
		JMenuItem mntmBuscarCadastro = new JMenuItem("Buscar cadastro");
		mntmBuscarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new TelaBusca());
				setTitle("Pesquisar");
				setVisible(true);
			}
		});
		mnBuscar.add(mntmBuscarCadastro);
		
		JMenu mnConfig=new JMenu("Configurações");
		menuBar.add(mnConfig);
		JMenuItem mntmSistema=new JMenuItem("Config. Sistema");
		mntmSistema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setContentPane(new TelaConfig());
				setTitle("Configurações do Sistema");
				setVisible(true);
			}
		});
		mnConfig.add(mntmSistema);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(39, 87, 513, 252);
		getContentPane().add(panel);
		// Encerrar aplicação
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				new TelaPopUpClose().setVisible(true); 
			}
		});
	}
}
