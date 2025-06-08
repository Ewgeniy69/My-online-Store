package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

import java.util.Arrays;

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
        System.out.println();

        basket.printBasket();
        System.out.println();

        int sum = basket.getTotalPrice();
        System.out.println(sum);
        System.out.println();

        basket.emptySpace();
        System.out.println();
        boolean isFound = basket.searchProduct(oranges);
        System.out.println(isFound);
        System.out.println();
        basket.cleanBasket();
        System.out.println();
        basket.printBasket();
        System.out.println();
        basket.searchProduct(banana);

        System.out.println("--- Поисковые мероприятия ---");

        SearchEngine engine = new SearchEngine(10);

        Article tv = new Article("Телевизор", "Цветной телевизор, без рамочный, бывший в употреблении");
        engine.add(tv);
        System.out.println("Добавлен объект - " + tv.getName());
        Article pc = new Article("Ноутбук", "Редкий экземпляр ноутбуков - стоимость 1 миллион долларов");
        engine.add(pc);
        System.out.println("Добавлен объект - " + pc.getName());
        Article home = new Article("Дом", "Продаю многоквартирный жилой дом по цене однокомнатной квартиры");
        engine.add(home);
        System.out.println("Добавлен объект - " + home.getName());
        engine.add(banana);
        System.out.println("Добавлен объект - " + banana.getName());
        engine.add(kiwi);
        System.out.println("Добавлен объект - " + kiwi.getName());
        engine.add(oranges);
        System.out.println("Добавлен объект - " + oranges.getName());

        //Пробую осуществить вывод в консоль путем поиска совпадений в цикле
        Searchable[] result = engine.search("ви");
        for (Searchable res : result) {
            if (res != null) {
                System.out.println(res.getStringRepresentation());
                System.out.println(res);
            }
        }
        //Пробую осуществить вывод в консоль через Arrays.toString
        Searchable[] print = engine.search("дом");
        System.out.println(Arrays.toString(print));


    }

}