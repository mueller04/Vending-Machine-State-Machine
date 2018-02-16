package src.domain;

public enum Product {

    CHIPS(0.50),
    CANDY(0.65),
    COLA(1.00);

    private double price;

    Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
