package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        System.out.println("--- Добавляем продукт в корзину:");
        if (product == null) {
            System.out.println("Строка - Продукт, не заполнена");
            return;
        }
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        System.out.println("В корзину добавлен продукт: " + product.getName() + ", стоимостью " + product.getPrice() + " руб.");
    }


    public int getTotalPrice() {
        System.out.println("--- Считаем общую стоимость продуктов в корзине:");
        int total = 0;
        for (List<Product> p : products.values()) {
            for (Product product : p) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        System.out.println("--- Содержимое корзины:");
        if (products.isEmpty()) {
            System.out.println("В корзине пусто!");
            return;
        }
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }
    }

    public boolean searchProduct(Product product) {
        System.out.println("--- Поиск продукта в корзине:");
        if (product == null) {
            System.out.println("Строка - Продукт, не заполнена");
            return false;
        }
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product1 : entry.getValue()) {
                if (product1.equals(product)) {
                    System.out.println("Товар " + product.getName() + ", найден в корзине");
                    return true;
                }
            }
        }
        System.out.println("Товар - " + product.getName() + ", в корзине отсутствует");
        return false;
    }

    public void cleanBasket() {
        System.out.println("--- Удаление продуктов из корзины:");
        int count = 0;
        for (List<Product> clear : products.values()) {
            count += clear.size();
        }
        products.clear();
        System.out.println("Корзина очищена. Удалено " + count + " наименование(я)!");
    }

    public List<Product> cleanBasketByName(String name) {
        List<Product> removeProduct = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            System.out.println("Название товара не указано!");
            return removeProduct;
        }
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            Iterator<Product> iterator = entry.getValue().iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (name.equals(product.getName())) {
                    removeProduct.add(product);
                    iterator.remove();
                    System.out.println("Удалено - " + product);
                }
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




