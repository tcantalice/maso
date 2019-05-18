package com.nipsters.view;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class TelaConfig extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaConfig() {
		
		setSize(600,500);
		setLayout(null);
		
		JLabel lblCommingSoon = new JLabel("Comming Soon!");
		lblCommingSoon.setBounds(245, 210, 127, 30);
		add(lblCommingSoon);
	}

}
