package src;

import src.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    public static Map<Product, Integer> setInventory() {
        Map<Product, Integer> newInventory = new HashMap<>();
        newInventory.put(Product.CANDY, 3);
        newInventory.put(Product.CHIPS, 2);
        newInventory.put(Product.COLA, 0);
        return newInventory;
    }

    public static Map<Product, Integer> sellProduct(Map<Product, Integer> inventory, Product product, int currentStock){
        Map<Product, Integer> newInventory = inventory;
        newInventory.put(product, currentStock - 1);
        return newInventory;
    }
}
