package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Ошибка стоимости продукта, бесплатный товар отсутствует");
        }
        this.basePrice = basePrice;
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Ошибка процента скидки");
        }
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
