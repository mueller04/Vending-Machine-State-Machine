package src.vendingmachine;

import src.domain.Coin;
import src.Inventory;
import src.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VendingMachineContext {

    VendingMachine vendingMachine;
    List<VendingMachine> vmStates = new ArrayList<>();

    public VendingMachineContext() {
        System.out.println("INSERT COIN");
        Map<Product, Integer> newInventory = Inventory.setInventory();
        setState(new ZeroBalanceVendingMachine(0, newInventory));
    }

    void setState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        vmStates.add(vendingMachine);
    }

    public void insertCoin(Coin coin) {
        vendingMachine.insertCoin(coin, this);
    }

    public void vend(Product product) {
        vendingMachine.vend(product, this);
    }

    public void returnCoins() {
        vendingMachine.returnCoins(this);
    }

    public void setExactChangeMode() {
        setState(new ExactChangeVendingMachine(vendingMachine.getBalance(),
                vendingMachine.getCoinReturnBalance(),
                vendingMachine.getInventory()));
        System.out.println("Now in exact change mode\n");
    }
}
