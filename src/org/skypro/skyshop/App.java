package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.BestResultNotFound;
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;


import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println(">>> Интернет-магазин <<<");

        ProductBasket basket = new ProductBasket();

        Product banana = new SimpleProduct("Бананы", 150);
        basket.addProduct(banana);
        Product kiwi = new DiscountedProduct("Киви", 300, 50);
        basket.addProduct(kiwi);
        Product oranges = new FixPriceProduct("Апельсины");
        basket.addProduct(oranges);
        Product gum = new SimpleProduct("Жевательная резинка", 300);
        Product nachos = new SimpleProduct("Чипсы", 200);
        Product apple = new SimpleProduct("Яблоко", 70);


        basket.printBasket();
        System.out.println();

        int sum = basket.getTotalPrice();
        System.out.println(sum);
        System.out.println();

        boolean isFound = basket.searchProduct(oranges);
        System.out.println(isFound);
        System.out.println();
        basket.cleanBasket();
        System.out.println();
        basket.printBasket();
        basket.searchProduct(banana);
        System.out.println();

        System.out.println("--- Поисковые мероприятия ---");

        SearchEngine engine = new SearchEngine();

        Article tv = new Article("Телевизор", "Цветной телевизор, без рамочный, бывший в употреблении");
        engine.add(tv);
        Article pc = new Article("Ноутбук", "Редкий экземпляр ноутбуков - стоимость 1 миллион долларов");
        engine.add(pc);
        Article home = new Article("Дом", "Продаю многоквартирный жилой дом по цене однокомнатной квартиры");
        engine.add(home);
        engine.add(banana);
        engine.add(kiwi);
        engine.add(oranges);
        System.out.println();

        //Пробую осуществить вывод в консоль путем поиска совпадений в цикле
        List<Searchable> result = engine.search("ви");
        for (Searchable res : result) {
            if (res != null) {
                System.out.println(res.getStringRepresentation());
                System.out.println(res);
            }
        }
        System.out.println();

        System.out.println("--- Создание продуктов с заведомо неверными данными ---");
        try {
            SimpleProduct carTires = new SimpleProduct("Авторезина", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
        try {
            DiscountedProduct toy = new DiscountedProduct("Игрушка", 200, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct boll = new DiscountedProduct("Мяч", 0, 50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        System.out.println("--- Работа с новым методом ---");

        Searchable[] searchItems = {tv, pc, oranges, banana, home, kiwi};
        try {
            Searchable bestMatch = engine.searchBestMatch("ут", searchItems);
            System.out.println("Лучшее совпадение: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable bestMatch2 = engine.searchBestMatch("лодка", searchItems);
            System.out.println("Лучшее совпадение: " + bestMatch2.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        basket.cleanBasket();
        System.out.println();

        System.out.println("--- Работа с проектом при измененной структуре данных на Linked");
        basket.addProduct(banana);
        basket.addProduct(kiwi);
        basket.addProduct(oranges);
        basket.addProduct(gum);
        basket.addProduct(nachos);
        basket.addProduct(apple);
        basket.printBasket();


        basket.cleanBasketByName("Бананы");
        basket.printBasket();
        basket.cleanBasketByName("Мандарины");
        basket.printBasket();


    }

}


