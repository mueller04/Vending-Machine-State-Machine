package src.vendingmachine;

import src.Utility;
import src.domain.Product;

import java.util.Map;

public class ExactChangeVendingMachine extends BalanceVendingMachine implements VendingMachine, VendAction {

    public ExactChangeVendingMachine(double balance, double coinReturnBalance, Map<Product, Integer> inventory) {
        super(balance, coinReturnBalance, inventory);
    }

    @Override
    public void setState(double balance, double coinReturnBalance, VendingMachineContext context, Map<Product, Integer> inventory) {
        ExactChangeVendingMachine vm = new ExactChangeVendingMachine(balance, coinReturnBalance, inventory);
        context.setState(vm);
    }

    @Override
    public boolean canVend(double productPrice) {
        return balance == productPrice;
    }

    @Override
    public void cannotVend(double productPrice) {
        System.out.println("EXACT CHANGE ONLY");
        System.out.println("PRICE " + Utility.formatCurrency(productPrice));
    }
}
