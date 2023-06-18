public class JDialog_AddCompAcc extends JDialog_AddAccount
{
	public JDialog_AddCompAcc(BankFrm parent)
	{
		super(parent, "Add Company account");


		JLabel6.setText("No of employees");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,240,96,24);


		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(120,240,156,20);

	}


	//{{DECLARE_CONTROLS
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NoOfEmp = new javax.swing.JTextField();
}