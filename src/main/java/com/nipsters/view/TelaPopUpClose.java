package com.nipsters.view;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPopUpClose extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			TelaPopUpClose dialog = new TelaPopUpClose();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TelaPopUpClose() {
		setSize(203,130);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("AVISO!");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblCloseMsg = new JLabel("Encerrar o Sistema?");
		lblCloseMsg.setBounds(49, 27, 127, 14);
		contentPanel.add(lblCloseMsg);

		JButton btnNo = new JButton("NÃO");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnNo) {  
					setVisible(false);  
				}
			}		
		});
		btnNo.setBounds(10, 66, 76, 23);
		contentPanel.add(btnNo);

		JButton btnSim = new JButton("SIM");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSim.setBounds(113, 66, 76, 23);
		contentPanel.add(btnSim);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(null);

		}
	}
}
