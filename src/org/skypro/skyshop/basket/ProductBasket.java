package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product [] products;
    private int size;

    public ProductBasket() {
        products = new Product[5];
    }

    public void addProduct (Product newproduct) {
        if (size >= products.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products [size++] = newproduct;
    }

    public int countPriceBasket () {
        if (products[0] == null) {
            return 0;
        }
        int price = 0;
        for (int i=0; i<size; i++) {
            price += products[i].getPrice();
        }
        return price;
    }

    public void printBasket () {
        System.out.println();
        System.out.println("Список продуктов в корзине:");
        if (products[0] == null) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i=0; i<size; i++) {
            System.out.println(products[i]);
        }
        System.out.println("Итого: "+ countPriceBasket() +" р.");
    }

    public boolean findProduct (String product) {
        if (products[0] == null) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (product.equals(products[i].getProductName())) {
                return true;
            }
        }
        return false;
    }

    public void emptyBasket () {
        for (int i=0; i<size; i++) {
            products[i] = null;
        }
    }
}
