package org.skypro.skyshop.product;

public abstract class Product {
    private String name;


    public Product(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Отсутствует наименование продукта!");
        }
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract String toString();

    public abstract boolean isSpecial();

}
