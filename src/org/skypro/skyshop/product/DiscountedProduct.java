package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        double finalPrice = basePrice * (1 - discount / 100.00);
        return (int) finalPrice;
    }

    @Override
    public String toString() {
        return super.getName() + ": " + getPrice() + " (скидка " + discount + " %)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
