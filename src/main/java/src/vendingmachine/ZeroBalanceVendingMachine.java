package src.vendingmachine;

import src.domain.Product;

import java.util.Map;

public class ZeroBalanceVendingMachine extends BalanceVendingMachine implements VendingMachine, VendAction {

    public ZeroBalanceVendingMachine(double coinReturnBalance, Map<Product, Integer> inventory) {
        super(0, coinReturnBalance, inventory);
    }

    @Override
    public boolean canVend(double productPrice) {
        return false;
    }

    @Override
    public void cannotVend(double productPrice) {
        System.out.println("YOU MUST FIRST INSERT COIN");
    }

    @Override
    public double getBalance() {
        return 0;
    }
}
