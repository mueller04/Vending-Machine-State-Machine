package src;

import src.domain.Coin;
import src.domain.Product;
import src.vendingmachine.VendingMachineContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    VendingMachineContext vm = new VendingMachineContext();
    Map<Coin, String> displayName = new HashMap<>();

    public void start() {
        createDisplayMap();

        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nPress 1 to insert a coin");
            System.out.println("Press 2 to make a purchase");
            System.out.println("Press 3 to return coins");
            System.out.println("Press 4 to set in exact change mode");
            System.out.println("Press 5 to exit the program");

            int selection = scanner.nextInt();

            if (selection == 1) {
                insertCoin();
            } if (selection == 2) {
                makeAPurchase();
            } if (selection == 3) {
                vm.returnCoins();
            } if (selection == 4) {
                vm.setExactChangeMode();
            } if (selection == 5) {
                keepRunning = false;
            }
        }
    }

    private void insertCoin() {
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nPress 1 for Penny");
            System.out.println("Press 2 for Nickel");
            System.out.println("Press 3 for Dime");
            System.out.println("Press 4 for Quarter");
            System.out.println("Press 5 to exit coin inserter");

            int coinSelection = scanner.nextInt();

            if (coinSelection == 1) {
                determineNumberOfCoins(Coin.PENNY);
            } else if (coinSelection == 2) {
                determineNumberOfCoins(Coin.NICKEL);
            } else if (coinSelection == 3) {
                determineNumberOfCoins(Coin.DIME);
            } else if (coinSelection == 4) {
                determineNumberOfCoins(Coin.QUARTER);
            } else if (coinSelection == 5) {
                keepRunning = false;
            }
        }
    }

    private void determineNumberOfCoins(Coin coin) {
        System.out.println("Enter number of " + displayName.get(coin) + " to insert");
        int numCoins = scanner.nextInt();

        for (int i = 0; i < numCoins; i++) {
            vm.insertCoin(coin);
        }
    }

    private void makeAPurchase() {
        System.out.println("Press 1 for Cola");
        System.out.println("Press 2 for Candy");
        System.out.println("Press 3 for Chips");

        int selection = scanner.nextInt();

        if (selection == 1) {
            vm.vend(Product.COLA);
        } else if (selection == 2) {
            vm.vend(Product.CANDY);
        } else if (selection == 3) {
            vm.vend(Product.CHIPS);
        }
    }

    private void createDisplayMap() {
        displayName.put(Coin.PENNY, "pennies");
        displayName.put(Coin.NICKEL, "nickels");
        displayName.put(Coin.DIME, "dimes");
        displayName.put(Coin.QUARTER, "quarters");
    }
}
