package creditcard;

import creditcard.view.CreditCardMainWindow;
import framework.Finco;


public class CCard extends Finco {

    public static void main(String[] args) {
        Finco.setAppWindow(new CreditCardMainWindow());
        Finco.main(args);
    }
}