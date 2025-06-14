package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {
    private final String name;


    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Отсутствует наименование продукта!");
        }
        this.name = name;

    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getSearchContent() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Наименование продукта - " + getName();
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

}
