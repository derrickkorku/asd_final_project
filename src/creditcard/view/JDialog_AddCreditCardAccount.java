package creditcard.view;

import framework.gui.JDialog_AddAccount;
import framework.gui.MainWindow;
import framework.owner.Owner;

import javax.swing.*;

public class JDialog_AddCreditCardAccount extends JDialog_AddAccount {
    private JRadioButton JRadioButton_Gold = new JRadioButton();
    private JRadioButton JRadioButton_Silver = new JRadioButton();
    private JRadioButton JRadioButton_Bronze = new JRadioButton();

    JLabel ccNumberLabel = new JLabel();
    JLabel expDateLabel = new JLabel();
    JLabel emailLabel = new JLabel();

    JTextField JTextField_CCNR = new JTextField();
    JTextField JTextField_ExpDate = new JTextField();
    JTextField JTextField_Email = new JTextField();

    MainWindow mainWindow;

    public JDialog_AddCreditCardAccount(MainWindow parentForm) {
        super(parentForm, "Add Credit Card Account");

        mainWindow = parentForm;

        setUpprivateComponents();

        //{{REGISTER_LISTENERS
        SymMouse aSymMouse = new SymMouse();
        JRadioButton_Gold.addMouseListener(aSymMouse);
        JRadioButton_Silver.addMouseListener(aSymMouse);


        JRadioButton_Bronze.addMouseListener(aSymMouse);
    }

    private void setUpprivateComponents() {
        JRadioButton_Gold.setText("Gold");
        JRadioButton_Gold.setActionCommand("Checkings");
        getContentPane().add(JRadioButton_Gold);
        JRadioButton_Gold.setBounds(36,12,84,24);

        JRadioButton_Silver.setText("Silver");
        JRadioButton_Silver.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Silver);
        JRadioButton_Silver.setBounds(36,36,84,24);

        JRadioButton_Bronze.setText("Copper");
        JRadioButton_Bronze.setActionCommand("Savings");
        getContentPane().add(JRadioButton_Bronze);
        JRadioButton_Bronze.setBounds(36,60,84,24);

        ccNumberLabel.setText("CC number");
        getContentPane().add(ccNumberLabel);
        ccNumberLabel.setForeground(java.awt.Color.black);
        ccNumberLabel.setBounds(12,216,96,24);

        getContentPane().add(JTextField_CCNR);
        JTextField_CCNR.setBounds(120,216,156,20);
        JTextField_CCNR.setText(Owner.getNextAccountNumber());
//
//
//        expDateLabel.setText("Exp. Date");
//        getContentPane().add(expDateLabel);
//        expDateLabel.setForeground(java.awt.Color.black);
//        expDateLabel.setBounds(12,226,72,24);
//
//        getContentPane().add(JTextField_ExpDate);
//        JTextField_ExpDate.setBounds(120,256,156,20);
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
    public void supplementJButtonOkayAP() {
        mainWindow.accountnr = JTextField_CCNR.getText();


        if (JRadioButton_Gold.isSelected())
            mainWindow.accountType="Gold";
        else{
            if (JRadioButton_Silver.isSelected())
                mainWindow.accountType="Silver";
            else
                mainWindow.accountType="Copper";
        }
    }
}
