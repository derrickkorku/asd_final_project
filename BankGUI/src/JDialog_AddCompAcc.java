public class JDialog_AddCompAcc extends JDialog_AddAccount
{
	private MainAppFrm parentframe;

	public JDialog_AddCompAcc(MainAppFrm parent)
	{
		super(parent, "Add Company account");
		this.parentframe = parent;
	}

	@Override
	public void setPostControls() {
		JLabel6.setText("No of employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,240,96,24);


		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(120,240,156,20);
	}

	@Override
	public void actionPerformedCheck() {
		if (JRadioButton_Chk.isSelected())
			parentframe.accountType="Ch";
		else
			parentframe.accountType="S";
	}

	public void setPreControls(){
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);
	}
}