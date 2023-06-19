public abstract class JDialog_AddAccount extends javax.swing.JDialog {
    private String title;
    private MainAppFrm parentframe;

    JDialog_AddAccount(MainAppFrm parent, String title){
        super(parent);

        this.parentframe = parent;
        this.title = title;

        setTitle(this.title);
        setModal(true);
        getContentPane().setLayout(null);
        setSize(400,600);
        setVisible(false);

        setPreControls();

        JLabel1.setText("Name");
        getContentPane().add(JLabel1);
        JLabel1.setForeground(java.awt.Color.black);
        JLabel1.setBounds(12,96,48,24);
        JLabel2.setText("Street");
        getContentPane().add(JLabel2);
        JLabel2.setForeground(java.awt.Color.black);
        JLabel2.setBounds(12,120,48,24);
        JLabel3.setText("City");
        getContentPane().add(JLabel3);
        JLabel3.setForeground(java.awt.Color.black);
        JLabel3.setBounds(12,144,48,24);
        JLabel4.setText("State");
        getContentPane().add(JLabel4);
        JLabel4.setForeground(java.awt.Color.black);
        JLabel4.setBounds(12,168,48,24);
        JLabel5.setText("Zip");
        getContentPane().add(JLabel5);
        JLabel5.setForeground(java.awt.Color.black);
        JLabel5.setBounds(12,192,48,24);

        JLabel7.setText("Email");
        getContentPane().add(JLabel7);
        JLabel7.setForeground(java.awt.Color.black);
        JLabel7.setBounds(12,216,48,24);

        getContentPane().add(JTextField_NAME);
        JTextField_NAME.setBounds(120,96,156,20);
        getContentPane().add(JTextField_CT);
        JTextField_CT.setBounds(120,144,156,20);
        getContentPane().add(JTextField_ST);
        JTextField_ST.setBounds(120,168,156,20);
        getContentPane().add(JTextField_STR);
        JTextField_STR.setBounds(120,120,156,20);
        getContentPane().add(JTextField_ZIP);
        JTextField_ZIP.setBounds(120,192,156,20);

        getContentPane().add(JTextField_EM);
        JTextField_EM.setBounds(120,216,156,20);


        JLabel8.setText("Number");
        getContentPane().add(JLabel8);
        JLabel8.setForeground(java.awt.Color.black);
        JLabel8.setBounds(12,240,48,24);
        getContentPane().add(JTextField_ACNR);
        JTextField_ACNR.setBounds(120,240,156,20);
        //}}

        setPostControls();

        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(48,300,84,24);
        JButton_Calcel.setText("Cancel");
        JButton_Calcel.setActionCommand("Cancel");
        getContentPane().add(JButton_Calcel);
        JButton_Calcel.setBounds(156,300,84,24);


        //{{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        JButton_Calcel.addActionListener(lSymAction);
        //}}
    }


    public abstract void setPreControls();
    public abstract void setPostControls();

    //{{DECLARE_CONTROLS

    javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();
    javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
    javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_BD = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_NoOfEmp = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
    javax.swing.JButton JButton_OK = new javax.swing.JButton();
    javax.swing.JButton JButton_Calcel = new javax.swing.JButton();
    javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
    javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
    javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
    javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
    javax.swing.JTextField JTextField_CCNR = new javax.swing.JTextField();
    javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();
    javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();

    javax.swing.JLabel Label7 = new javax.swing.JLabel();


    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
            else if (object == JButton_Calcel)
                JButtonCalcel_actionPerformed(event);
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {
        parentframe.ccnumber = JTextField_ACNR.getText();
        parentframe.clientName=JTextField_NAME.getText();
        parentframe.street=JTextField_STR.getText();
        parentframe.city=JTextField_CT.getText();
        parentframe.zip=JTextField_ZIP.getText();
        parentframe.state=JTextField_ST.getText();

        actionPerformedCheck();

        parentframe.newaccount=true;
        dispose();

    }

    public abstract void actionPerformedCheck();

    void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
    {
        dispose();
    }
}
