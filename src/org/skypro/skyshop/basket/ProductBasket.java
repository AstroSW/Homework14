package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> products;

    public ProductBasket() {
        products = new LinkedList<>();
    }

    public void addProduct(Product newproduct) {
        products.add(newproduct);
    }

    public int countPriceBasket() {
        int price = 0;
        for (Product item : products) {
            price += item.getPrice();
        }
        return price;
    }

    public void printBasket() {
        System.out.println();
        System.out.println("Список продуктов в корзине:");
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int n = 0;
        for (Product item : products) {
            System.out.println(item);
            if (item.isSpecial()) {
                n++;
            }
        }
        System.out.println("Итого: " + countPriceBasket() + " р.");
        System.out.println("Специальных товаров: " + n);
    }

    public boolean findProduct(String product) {
        if (products.isEmpty()) {
            return false;
        }
        for (Product item : products) {
            if (product.equals(item.getName())) {
                return true;
            }
        }
        return false;
    }

    public void emptyBasket() {
        products.clear();
    }

    public List deleteProduct(String productName) {
        List<Product> productsDelete = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product item = iterator.next();
            if (productName.equals(item.getName())) {
                productsDelete.add(item);
                iterator.remove();
            }
        }
        return productsDelete;
    }

    public void printDeleteProducts(List products) {
        System.out.println("Список удалённых продуктов:");
        if (products.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (Object item : products) {
            System.out.println(item);
        }
    }
}
