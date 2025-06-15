package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        this.products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        System.out.println("--- Добавляем продукт в корзину:");
        if (product == null) {
            System.out.println("Строка - Продукт, не заполнена");
            return;
        }
        products.add(product);
        System.out.println("В корзину добавлен продукт: " + product.getName() + ", стоимостью " + product.getPrice() + " руб.");
    }

    public int getTotalPrice() {
        System.out.println("--- Считаем общую стоимость продуктов в корзине:");
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void printBasket() {
        System.out.println("--- Содержимое корзины:");
        if (products.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public boolean searchProduct(Product product) {
        System.out.println("--- Поиск продукта в корзине:");
        if (product == null) {
            System.out.println("Строка - Продукт, не заполнена");
            return false;
        }
        for (Product product1 : products) {
            if (product1.equals(product)) {
                System.out.println("Товар " + product.getName() + ", найден в корзине");
                return true;
            }
        }
        System.out.println("Товар - " + product.getName() + ", в корзине отсутствует");
        return false;

    }

    public void cleanBasket() {
        System.out.println("--- Удаление продуктов из корзины:");
        int product = products.size();
        products.clear();
        System.out.println("Корзина очищена. Удалено " + product + " наименование(я)!");
    }

    public List<Product> cleanBasketByName(String name) {
        List<Product> removeProduct = new LinkedList<>();
        if (name == null) {
            return removeProduct;
        }
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (name.equals(p.getName())) {
                removeProduct.add(p);
                iterator.remove();
                System.out.println("Удалено - " + p);
            }
        }
        if (removeProduct.isEmpty()) {
            System.out.println("Товар - " + name + ", в корзине отсутствует!");
            System.out.println("Список удаленных товаров пуст!");
            return removeProduct;
        }
        return removeProduct;


    }
}



