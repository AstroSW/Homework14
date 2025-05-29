package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new Product("Бананы", 170));
        productBasket.addProduct(new Product("Яблоки", 105));
        productBasket.addProduct(new Product("Апельсины", 96));
        productBasket.addProduct(new Product("Хлеб", 18));
        productBasket.addProduct(new Product("Шоколад", 80));

        System.out.println();
        productBasket.addProduct(new Product("Пельмени", 248));
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