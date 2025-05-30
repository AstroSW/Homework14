package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new SimpleProduct("Бананы", 170));
        productBasket.addProduct(new DiscountedProduct("Яблоки", 105, 10));
        productBasket.addProduct(new FixPriceProduct("Апельсины"));
        productBasket.addProduct(new SimpleProduct("Хлеб", 18));
        productBasket.addProduct(new DiscountedProduct("Шоколад", 90, 35));

        System.out.println();
        productBasket.addProduct(new SimpleProduct("Пельмени", 248));
        productBasket.printBasket();
        System.out.println();
        System.out.println("Стоимость корзины: "+ productBasket.countPriceBasket() +" р." );
        System.out.println();
        System.out.println("Хлеб "+ productBasket.findProduct("Хлеб"));
        System.out.println("Пельмени "+ productBasket.findProduct("Пельмени"));

        productBasket.emptyBasket();
        productBasket.printBasket();
        System.out.println("Стоимость корзины: "+ productBasket.countPriceBasket() +" р." );
        System.out.println("Хлеб "+ productBasket.findProduct("Хлеб"));


    }
}