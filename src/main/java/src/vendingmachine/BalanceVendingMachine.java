package src.vendingmachine;

import src.*;
import src.domain.Coin;
import src.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class BalanceVendingMachine implements VendingMachine, VendAction {

    protected final double balance;
    protected final double coinReturnBalance;
    private Map<Product, Integer> inventory = new HashMap<>();

    public BalanceVendingMachine(double balance, double coinReturnBalance, Map<Product, Integer> inventory) {
        this.coinReturnBalance = coinReturnBalance;
        this.balance = balance;
        this.inventory = inventory;
    }

    @Override
    public void insertCoin(Coin coin, VendingMachineContext context) {

        double newCoinReturnBalance = coinReturnBalance;
        double newBalance = balance;

        if (coin == Coin.PENNY) {
            newCoinReturnBalance += .01;
        } else {
            newBalance = balance + coin.getValue();
        }

        System.out.println("Balance: " + Utility.formatCurrency(newBalance));
        setState(newBalance, newCoinReturnBalance, context, getInventory());
    }

    @Override
    public void setState(double balance, double coinReturnBalance, VendingMachineContext context, Map<Product, Integer> inventory) {
        BalanceVendingMachine vm = new BalanceVendingMachine(balance, coinReturnBalance, inventory);
        context.setState(vm);
    }

    @Override
    public void vend(Product product, VendingMachineContext context) {
        if (canVend(product.getPrice())) {
            vendProduct(product, context);
            System.out.println("INSERT COIN");
        } else {
            cannotVend(product.getPrice());
        }
    }

    private void vendProduct(Product product, VendingMachineContext context) {
        Integer stock = inventory.get(product);

        if (stock > 0) {
            System.out.println("You purchased a " + product);
            System.out.println("THANK YOU");

            double newCoinReturnBalance = balance - product.getPrice();
            System.out.println("Balance in coin return is "
                    + Utility.formatCurrency(newCoinReturnBalance)
                    + "\n");

            Map<Product, Integer> newInventory = Inventory.sellProduct(inventory, product, stock);
            setState(0, newCoinReturnBalance, context, newInventory);
        } else {
            System.out.println("SOLD OUT\n");
        }
    }

    @Override
    public void returnCoins(VendingMachineContext context) {
        double newCoinReturnBalance = coinReturnBalance + balance;
        System.out.println(Utility.formatCurrency(newCoinReturnBalance) + " Is in the return slot\n");
        setState(0, 0, context, getInventory());
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getCoinReturnBalance() {
        return coinReturnBalance;
    }

    @Override
    public Map<Product, Integer> getInventory() {
        return inventory;
    }

    @Override
    public boolean canVend(double productPrice) {
        return balance >= productPrice;
    }

    @Override
    public void cannotVend(double productPrice) {
        System.out.println("PRICE " + Utility.formatCurrency(productPrice));
    }
}
