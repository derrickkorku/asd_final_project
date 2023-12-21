package framework;
import framework.gui.MainWindow;
import framework.view.AppWindow;

import javax.swing.*;

public class Finco {
    private static MainWindow appWindow;

    public static void main(String[] args) {
        try {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            /**
             * Load Account Manager Window(View)
             */
            appWindow.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            // Ensure the application exits with an error condition.
            System.exit(1);
        }
    }

    public static void setAppWindow(MainWindow appWindow1) {
        appWindow = appWindow1;
    }
}