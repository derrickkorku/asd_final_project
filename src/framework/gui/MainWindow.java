package framework.gui;
import framework.account.IAccount;
import framework.controllers.BaseController;
import framework.utilities.Response;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MainWindow extends javax.swing.JFrame{
    /****
     * init variables in the object
     ****/
    public String accountnr;
    public String clientName;
    public String street;
    public String city;
    public String zip;
    public String state;
    public String accountType;
    public String clientType;
    public String amountDeposit;
    public String email;
    public boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    MainWindow myframe;
    private Object rowdata[];
    public SymAction lSymAction;
    private SymWindow aSymWindow;

    private List<String> tableColumns;


    public MainWindow(String title){
        myframe = this;
        setTitle(title);

        aSymWindow = new SymWindow();
        myframe.addWindowListener(aSymWindow);
        lSymAction = new SymAction();

        this.initializeWindow();
        this.initializeTable();
        this.setUpDefaultButtons();
    }

    private void initializeTable(){
        JScrollPane1 = new JScrollPane();
        model = new DefaultTableModel();
        JTable1 = new JTable(model);
        this.setTableColumns();
        rowdata = new Object[this.getTableColumns().size()];

        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,440,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
    }
    private void initializeWindow(){
        setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0,0));
        setSize(600,400);
        setVisible(false);

        JPanel1.setLayout(null);
        getContentPane().add(BorderLayout.CENTER, JPanel1);
        JPanel1.setBounds(0,0,584,324);
    }

    private void setUpDefaultButtons(){
        this.setupInterestButton();
        this.setupCreditButton();
        this.setupDebitButton();
        this.setupGenerateReportButton();
        this.setupExitButton();
    }

    private void setupInterestButton(){
        JButton_Addinterest.setText("Add interest");
        JPanel1.add(JButton_Addinterest);
        JButton_Addinterest.setBounds(448,20,106,33);
        JButton_Addinterest.addActionListener(lSymAction);
    }
    private void setupExitButton(){
        JButton_Exit.setText("Exit");
        JPanel1.add(JButton_Exit);
        JButton_Exit.setBounds(468,300,96,30);
        JButton_Exit.addActionListener(lSymAction);
    }

    private void setupGenerateReportButton(){
        JButton_GenerateReport.setText("Report");
        JPanel1.add(JButton_GenerateReport);
        JButton_GenerateReport.setBounds(468,220,96,30);
        JButton_GenerateReport.addActionListener(lSymAction);
    }

    private void setupCreditButton(){
        JButton_Credit.setText(this.getCreditButtonTitle());
        JPanel1.add(JButton_Credit);
        JButton_Credit.setBounds(468,104,96,33);
        JButton_Credit.addActionListener(lSymAction);
    }
    public abstract String getCreditButtonTitle();

    private void setupDebitButton(){
        JButton_Debit.setText(this.getDebitButtonTitle());
        JPanel1.add(JButton_Debit);
        JButton_Debit.setBounds(468,164,96,34);
        JButton_Debit.addActionListener(lSymAction);
    }

    public abstract String getDebitButtonTitle();
    public String getReportString(){
        List<IAccount> accountList = BaseController.allAccounts();

        StringBuilder builder = new StringBuilder("");
        for (IAccount account : accountList){
            builder.append(account.getAccountOwner().toString()).append("\n").append(account.toString()).append("\n");
            builder.append("-------------------------------------------");
        }

        return builder.toString();
    }

    javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
    javax.swing.JButton JButton_Exit = new javax.swing.JButton();
    javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
    javax.swing.JButton JButton_Credit = new javax.swing.JButton();
    javax.swing.JButton JButton_Debit = new javax.swing.JButton();
    javax.swing.JButton JButton_GenerateReport = new javax.swing.JButton();

    void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event) {
        JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
        BaseController.applyInterest();
        List<IAccount> accounts = BaseController.allAccounts();
        System.out.println(accounts.toString());
        updateAcountsBalances(accounts);
    }

    public void addExtraButton(JButton button){
        JPanel1.add(button);
    }

    public List<String> getTableColumns() {
        List<String> list = new ArrayList<>();
        list.add("Number");
        list.add("Name");
        list.add("Street");
        list.add("City");
        list.add("State");
        list.add("Zip");
        list.add("Amount");

        return list;
    }

    private void setTableColumns(){
        for (String column : this.getTableColumns()){
            model.addColumn(column);
        }

        rowdata = new Object[this.getTableColumns().size()];
        newaccount = false;
    }

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();

            if (object == JButton_Exit){
                JButtonExit_actionPerformed(event);
                return;
            }

            if (object == JButton_Addinterest){
                JButtonAddinterest_actionPerformed(event);
                return;
            }

            if (object == JButton_Credit){
                JButtonCredit_actionPerformed(event);
                return;
            }

            if (object == JButton_Debit){
                JButtonDebit_actionPerformed(event);
                return;
            }

            if (object == JButton_GenerateReport){
                JButtonGenerateReport_actionPerformed(event);
                return;
            }

            subActionsPerformed(event);
        }
    }

    public abstract void subActionsPerformed(java.awt.event.ActionEvent event);

    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
    {
        System.exit(0);
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(java.awt.event.WindowEvent event)
        {
            Object object = event.getSource();
            if (object == MainWindow.this)
                MainFrm_windowClosing(event);
        }
    }

    void MainFrm_windowClosing(java.awt.event.WindowEvent event)
    {
        MainFrm_windowClosing_Interaction1(event);
    }

    void MainFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            this.exitApplication();
        } catch (Exception e) {
        }
    }


    void JButtonCredit_actionPerformed(java.awt.event.ActionEvent event) {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >= 0){
            String accnr = (String)model.getValueAt(selection, getAccountNumberIndex());

            //Show the dialog for adding deposit amount for the current mane
            JDialog_AddEntry dep = new JDialog_AddEntry(myframe,accnr, this.getCreditButtonTitle());
            dep.setBounds(430, 15, 275, 140);
            dep.show();

            // compute new amount
            Double deposit = Double.parseDouble(amountDeposit);

            //get column index for balance/Amount
            int amountColumnIndex = getAmountColumnIndex();
            String samount = (String)model.getValueAt(selection, amountColumnIndex);
            Double currentamount = Double.parseDouble(samount);
            Double newamount = currentamount+deposit;

            model.setValueAt(String.valueOf(newamount),selection, amountColumnIndex);

            Response response = BaseController.credit(accnr, deposit);
            JOptionPane.showMessageDialog(this, response.getMessage());
        }
    }

    public abstract int getAmountColumnIndex();


    public int getAccountNumberIndex() {
        return 0;
    }

    void JButtonDebit_actionPerformed(java.awt.event.ActionEvent event)
    {
        // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, getAccountNumberIndex());

            //Show the dialog for adding withdraw amount for the current mane
            JDialog_AddEntry wd = new JDialog_AddEntry(myframe, accnr, this.getDebitButtonTitle());
            wd.setBounds(430, 15, 275, 140);
            wd.show();

            int amountColumnIndex = getAmountColumnIndex();

            // compute new amount
            Double deposit = Double.parseDouble(amountDeposit);

            String samount = (String)model.getValueAt(selection, amountColumnIndex);
            Double currentamount = Double.parseDouble(samount);

            if ((currentamount-deposit) < 0){
                JOptionPane.showMessageDialog(this, " Balance not enough for transaction !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
                return;
            }

            Double newamount = currentamount-deposit;

            model.setValueAt(String.valueOf(newamount),selection, amountColumnIndex);

            Response response = BaseController.debit(accnr, deposit);
            JOptionPane.showMessageDialog(this, response.getMessage());
        }
    }

    void JButtonGenerateReport_actionPerformed(java.awt.event.ActionEvent event)
    {
        JDialog_GenerateReport generateReport = new JDialog_GenerateReport(this, "Generate Account Report");
        generateReport.setBounds(450, 20, 400, 350);
        generateReport.show();

    }

    public void populateTable(String[] data){
        this.getTableColumns();
        for (int i = 0; i < this.getTableColumns().size() ; i++) {
            rowdata[i] = data[i];
        }

        model.addRow(rowdata);
        JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
        newaccount=false;
    }

    public void updateAcountsBalances(List<IAccount> accounts){
        for (int i = 0; i < accounts.size(); i++){
            model.setValueAt(String.valueOf(accounts.get(i).getBalance()), i, this.getTableColumns().size() - 1);
        }
    }

    void exitApplication()
    {
        try {
            this.setVisible(false);    // hide the Frame
            this.dispose();            // free the system resources
            System.exit(0);            // close the application
        } catch (Exception ignored) {
        }
    }
}
