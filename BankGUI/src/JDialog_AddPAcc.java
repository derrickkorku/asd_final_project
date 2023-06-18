public class JDialog_AddPAcc extends JDialog_AddAccount
{
	public JDialog_AddPAcc(BankFrm parent)
	{
		super(parent, "Add personal account");

		JLabel6.setText("Birthdate");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,240,96,24);


		getContentPane().add(JTextField_BD);
		JTextField_BD.setBounds(120,240,156,20);
	}

	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
}