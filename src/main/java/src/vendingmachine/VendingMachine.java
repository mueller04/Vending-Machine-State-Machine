package src.vendingmachine;

import src.domain.Coin;
import src.domain.Product;

import java.util.Map;

public interface VendingMachine {

    void insertCoin(Coin coin, VendingMachineContext context);
    void vend(Product product, VendingMachineContext context);
    void returnCoins(VendingMachineContext context);
    double getBalance();
    double getCoinReturnBalance();
    Map<Product, Integer> getInventory();
    void setState(double balance, double coinReturnBalance, VendingMachineContext context, Map<Product, Integer> inventory);
}
