package banking;

import banking.view.BankWindow;
import framework.Finco;


public class Bank extends Finco {

    public static void main(String[] args) {
        Finco.setAppWindow(new BankWindow());
        Finco.main(args);
    }

}
