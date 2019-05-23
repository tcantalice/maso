package com.nipsters.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PainelTelaInicio extends JPanel {

	private static final long serialVersionUID = 1L;

	public PainelTelaInicio() {
		setSize(600,500);
		setLayout(null);
		
		JButton btnClickMe = new JButton("Click me for Happiness");
		btnClickMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Fui clicado, modafoca!!!","Sou foda",JOptionPane.WARNING_MESSAGE);
			}
		});
		btnClickMe.setBounds(189, 226, 189, 23);
		add(btnClickMe);



	}
}
