package framework.view;

import framework.gui.JDialog_AddAccount;
import framework.gui.MainWindow;
import framework.owner.Owner;

import javax.swing.*;
import java.awt.*;

public class JDialog_AddAccountDemo extends JDialog_AddAccount
{
    private MainWindow parentframe;
    
	public JDialog_AddAccountDemo(MainWindow parent)
	{
		super(parent,"Add Account");
		parentframe = parent;

		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,0,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,24,84,24);


		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,216,96,24);

		accNumLabel.setText("Number");
		getContentPane().add(accNumLabel);
		accNumLabel.setForeground(Color.black);
		accNumLabel.setBounds(12,72,48,24);

		JTextField_AccNum.setEnabled(false);
		getContentPane().add(JTextField_AccNum);
		JTextField_AccNum.setBounds(120,72,156,20);
		JTextField_AccNum.setText(Owner.getNextAccountNumber());


		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(120,216,156,20);

	
		//{{REGISTER_LISTENERS
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
	}


	//{{DECLARE_CONTROLS
	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
	JTextField JTextField_AccNum = new JTextField();

	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();

	javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();

	javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	JLabel accNumLabel = new JLabel();

	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Checking radio is clicked make this radio on 
		//and make Saving account radio off
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
	{
		//When Saving radio is clicked make this radio on 
		//and make Checking account radio off
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);
	 
	}

	@Override
	public void supplementJButtonOkayAP() {
		//Set public variables on MainWindow frame
		parentframe.accountnr = JTextField_ACNR.getText();
		parentframe.accountnr = JTextField_AccNum.getText();

		if (JRadioButton_Chk.isSelected())
			parentframe.accountType="Ch";
		else
			parentframe.accountType="S";
	}
}