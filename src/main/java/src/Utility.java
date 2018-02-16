package src;

import java.text.NumberFormat;

public class Utility {

    public static String formatCurrency(double amount) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return numberFormat.format(amount);
    }
}
