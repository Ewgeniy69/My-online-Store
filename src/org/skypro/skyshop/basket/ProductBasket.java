package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products;
    private int counter;

    public ProductBasket() {
        this.products = new Product[5];
        this.counter = 0;
    }

    public void addProduct(Product product) {
        System.out.println("--- Добавляем продукт в корзину:");
        if (counter >= products.length) {
            System.out.println("Место в корзине отсутствует ");
        }
        if (counter < products.length) {
            products[counter] = product;
            counter++;
            System.out.println("В корзину добавлен продукт: " + product.getName() + ", стоимостью " + product.getPrice() + " руб.");
        }
    }

    public void emptySpace() {
        System.out.println("--- Остаток места в корзине:");
        int space = products.length - counter;
        System.out.println("В корзине осталось " + space + " места для продуктов");
    }

    public int getTotalPrice() {
        System.out.println("--- Считаем общую стоимость продуктов в корзине:");
        int total = 0;
        for (int i = 0; i < counter; i++) {
            if (products[i] != null) {
                total += products[i].getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        System.out.println("--- Содержимое корзины:");
        int total = 0;
        int countSpecial = 0;

        if (counter == 0) {
            System.out.println("В корзине пусто!");

        } else {
            for (int i = 0; i < counter; i++) {
                System.out.println(products[i].toString());
                total += i;
                if (products[i].isSpecial())
                    countSpecial++;
            }
        }
        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + countSpecial);
    }

    public boolean searchProduct(Product product) {
        System.out.println("--- Поиск продукта в корзине:");
        for (int i = 0; i < counter; i++) {
            if (products[i].equals(product)) {
                System.out.println("Товар " + product.getName() + ", найден в корзине");
                return true;
            }
        }
        System.out.println("Товар - " + product.getName() + ", в корзине отсутствует");
        return false;

    }

    public void cleanBasket() {
        System.out.println("--- Удаление продуктов из корзины:");
        for (int i = 0; i < counter; i++) {
            products[i] = null;
            counter = 0;
        }
        System.out.println("Корзина очищена");

    }
}



