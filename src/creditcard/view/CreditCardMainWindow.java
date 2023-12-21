package creditcard.view;

import creditcard.controllers.CreditCardController;
import framework.gui.MainWindow;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreditCardMainWindow extends MainWindow {
    javax.swing.JButton JButton_AddAccount = new javax.swing.JButton();
    javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();


    public CreditCardMainWindow(){
        super("Credit Card Processing Application.");
        this.setUpAddAccountsButtons();

    }

    private void setUpAddAccountsButtons(){
        JButton_AddAccount.setText("Add Credit-card account");
        this.addExtraButton(JButton_AddAccount);
        JButton_AddAccount.setBounds(24,20,192,33);
        JButton_AddAccount.setActionCommand("jbutton");


        JButton_AddAccount.addActionListener(lSymAction);
    }


    @Override
    public String getCreditButtonTitle() {
        return "Deposit";
    }

    @Override
    public String getDebitButtonTitle() {
        return "Charge";
    }

    @Override
    public void subActionsPerformed(ActionEvent event) {
        Object object = event.getSource();

        if (object == JButton_AddAccount){
            JButtonAddAccount_actionPerformed(event);
            return;
        }
    }

    @Override
    public int getAmountColumnIndex() {
        return this.getTableColumns().size() - 1;
    }

    @Override
    public int getAccountNumberIndex() {
        return 1;
    }

    @Override
    public List<String> getTableColumns() {
        List<String> list = new ArrayList<>();
        list.add("Name");
        list.add("CC number");
        list.add("Exp date");
        list.add("Type");
        list.add("Balance");

        return list;
    }


    void JButtonAddAccount_actionPerformed(java.awt.event.ActionEvent event)
    {
        /**
         * Open customized Add Person Aaccount Dialog
         */
        JDialog_AddCreditCardAccount pac = new JDialog_AddCreditCardAccount(this);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

        if (newaccount){
           // String[] data = {accountnr, clientName, city, "P", accountType, "0"};
            LocalDate mockExpDate = LocalDate.now().plusYears(4);
            String[] data = {clientName, accountnr, mockExpDate.toString(), accountType, "0"};
            CreditCardController.createAccount(clientName, street, city, zip, email, accountType);
            this.populateTable(data);
        }


    }

}
