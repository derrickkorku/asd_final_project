package framework.view;

import framework.controllers.BaseController;
import framework.gui.MainWindow;
import java.awt.event.ActionEvent;

public class AppWindow extends MainWindow {
    javax.swing.JButton JButton_AddAccount = new javax.swing.JButton();

    public AppWindow(){
        super("Framework Account Application");

        this.setUpAddAccountsButtons();
    }

    private void setUpAddAccountsButtons(){
        JButton_AddAccount.setText("Add Account");
        this.addExtraButton(JButton_AddAccount);
        JButton_AddAccount.setBounds(24,20,192,33);
        JButton_AddAccount.setActionCommand("jbutton");

        JButton_AddAccount.addActionListener(lSymAction);
    }


    @Override
    public String getCreditButtonTitle() {
        return "Credit";
    }

    @Override
    public String getDebitButtonTitle() {
        return "Debit";
    }

    @Override
    public void subActionsPerformed(ActionEvent event) {
        Object object = event.getSource();

        if (object == JButton_AddAccount){
            JButtonAddAccount_actionPerformed(event);
        }
    }

    @Override
    public int getAmountColumnIndex() {
        return this.getTableColumns().size() - 1;
    }

    void JButtonAddAccount_actionPerformed(java.awt.event.ActionEvent event)
    {
        /**
         * Open customized Add Person Aaccount Dialog
         */
        JDialog_AddAccountDemo pac = new JDialog_AddAccountDemo(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount) {
            String dateOfBirthSt = pac.JTextField_BD.getText();
            String[] data = {accountnr, clientName, street , city, state, zip, "0"};
            BaseController.createAccount(clientName, street, city, zip, email, dateOfBirthSt, accountType);
            this.populateTable(data);
        }
    }

}
