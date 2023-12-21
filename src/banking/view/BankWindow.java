package banking.view;
import banking.controllers.BankController;
import framework.gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class BankWindow extends MainWindow {
    JButton JButton_PerAC = new javax.swing.JButton();
    JButton JButton_CompAC = new javax.swing.JButton();


    public BankWindow() {
        super("Bank");
        this.setUpAddAccountsButtons();
    }

    private void setUpAddAccountsButtons(){
        JButton_PerAC.setText("Add personal account");
        this.addExtraButton(JButton_PerAC);
        JButton_PerAC.setBounds(24,20,192,33);
        JButton_PerAC.setActionCommand("jbutton");

        JButton_CompAC.setText("Add company account");
        JButton_CompAC.setActionCommand("jbutton");
        this.addExtraButton(JButton_CompAC);
        JButton_CompAC.setBounds(240,20,190,33);

        JButton_PerAC.addActionListener(lSymAction);
        JButton_CompAC.addActionListener(lSymAction);
    }


    @Override
    public String getCreditButtonTitle() {
        return "Deposit";
    }

    @Override
    public String getDebitButtonTitle() {
        return "Withdrawal";
    }

    @Override
    public void subActionsPerformed(ActionEvent event) {
        Object object = event.getSource();

        if (object == JButton_PerAC){
            JButtonPerAC_actionPerformed(event);
            return;
        }

        if (object == JButton_CompAC){
            JButtonCompAC_actionPerformed(event);
        }
    }

    @Override
    public int getAmountColumnIndex() {
        return this.getTableColumns().size() - 1;
    }

    @Override
    public List<String> getTableColumns() {
            List<String> list = new ArrayList<>();
            list.add("Number");
            list.add("Name");
            list.add("Street");
            list.add("City");
            list.add("State");
            list.add("Zip");
            list.add("P/C");
            list.add("Ch/s");
            list.add("Amount");

            return list;
    }


    void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event) {
        /**
         * Open customized Add Person Aaccount Dialog
         */
        JDialog_AddPAcc pac = new JDialog_AddPAcc(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount) {
            String dateOfBirthSt = pac.JTextField_BD.getText();
            String[] data = {accountnr, clientName, street , city, state, zip, "P", accountType, "0"};
            BankController.createAccount(clientName, street, city, zip, email, dateOfBirthSt, accountType);
            this.populateTable(data);
        }


    }

    void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event) {

        /**
         * Open customized Add Company Account Dialog
         */
        JDialog_AddCompAcc pac = new JDialog_AddCompAcc(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        int noOfEmp = Integer.parseInt(pac.JTextField_NoOfEmp.getText());

        if (newaccount) {
            String[] data = {accountnr, clientName, street , city, state, zip, "C", accountType, "0"};
            BankController.createAccount(clientName, street, city, zip, email, noOfEmp, accountType);
            this.populateTable(data);
        }
    }
}
