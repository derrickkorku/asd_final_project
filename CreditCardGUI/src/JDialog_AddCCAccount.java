public class JDialog_AddCCAccount extends JDialog_AddAccount
{
    private MainAppFrm parentframe;
    
	public JDialog_AddCCAccount(MainAppFrm parent)
	{
		super(parent, "Add credit card account");
		this.parentframe = parent;
	}

	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == JRadioButton_Gold)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Silver)
				JRadioButtonSav_mouseClicked(event);
			else if (object == JRadioButton_Bronze)
				JRadioButtonBronze_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
	{
		JRadioButton_Gold.setSelected(true);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Bronze.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
	{
		JRadioButton_Gold.setSelected(false);
		JRadioButton_Silver.setSelected(true);
		JRadioButton_Bronze.setSelected(false);
	 
	}
	void JRadioButtonBronze_mouseClicked(java.awt.event.MouseEvent event)
	{
		JRadioButton_Gold.setSelected(false);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Bronze.setSelected(true);
			 
	}

	@Override
	public void setPreControls() {
		JRadioButton_Gold.setText("Gold");
		JRadioButton_Gold.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Gold);

		JRadioButton_Gold.setBounds(36,12,84,24);
		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(36,36,84,24);

		JRadioButton_Bronze.setText("Bronze");
		JRadioButton_Bronze.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Bronze);
		JRadioButton_Bronze.setBounds(36,60,84,24);
	}

	@Override
	public void setPostControls() {
		Label7.setText("Exp. Date");
		getContentPane().add(Label7);
		Label7.setForeground(java.awt.Color.black);
		Label7.setBounds(12,265,48,24);

		getContentPane().add(JTextField_ExpDate);
		JTextField_ExpDate.setBounds(120,265,156,20);
	}

	@Override
	public void actionPerformedCheck() {
		parentframe.expdate=JTextField_ExpDate.getText();
		if (JRadioButton_Gold.isSelected())
			parentframe.accountType="Gold";
		else{
			if (JRadioButton_Silver.isSelected())
				parentframe.accountType="Silver";
			else
				parentframe.accountType="Bronze";
		}
	}
}