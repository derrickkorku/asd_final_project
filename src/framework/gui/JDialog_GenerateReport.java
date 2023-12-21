package framework.gui;

import javax.swing.*;

public class JDialog_GenerateReport extends javax.swing.JDialog
{
    private MainWindow parentForm;
    private String title = "Account Reports";

    private JTextArea textArea = new JTextArea();

    public JDialog_GenerateReport(MainWindow parentForm, String title)
    {
        this.title = title;
        this.parentForm = parentForm;

        //{{ INIT_CONTROLS
        getContentPane().setLayout(null);
        setSize(450,400);
        setVisible(false);


        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(156,276,96,24);

        textArea.setText(parentForm.getReportString());

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(24,24,358,240);
        getContentPane().add(scrollPane);

        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        //}}
    }

    javax.swing.JButton JButton_OK = new javax.swing.JButton();

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
        }
    }

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
    {
        dispose();
    }
}
