package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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


    }

}