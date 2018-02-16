package src.vendingmachine;

public interface VendAction {
    boolean canVend(double productPrice);
    void cannotVend(double productPrice);
}
