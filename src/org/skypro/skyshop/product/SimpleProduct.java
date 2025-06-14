package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price <= 0) {
            throw new IllegalArgumentException("Ошибка стоимости продукта, бесплатный товар отсутствует");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return super.getName() + ": " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

}
