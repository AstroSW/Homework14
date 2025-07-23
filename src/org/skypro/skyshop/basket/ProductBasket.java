package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public void addProduct(Product newproduct) {
        products.computeIfAbsent(newproduct.getName(),k -> new ArrayList<>()).add(newproduct);
        //if (!products.containsKey(newproduct.getName())) {
        //    products.put(newproduct.getName(), new ArrayList<>());
        //}
        //products.get(newproduct.getName()).add(newproduct);
    }

    public int countPriceBasket() {
        int price = 0;
        for (List<Product> item : products.values()) {
            for (Product p : item) {
                price += p.getPrice();
            }
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
        for (List<Product> item : products.values()) {
            for (Product p : item) {
                System.out.println(p);
                if (p.isSpecial()) {
                    n++;
                }
            }
        }
        System.out.println("Итого: " + countPriceBasket() + " р.");
        System.out.println("Специальных товаров: " + n);
    }

    public boolean findProduct(String product) {
        if (products.isEmpty()) {
            return false;
        }
        for (List<Product> item : products.values()) {
            for (Product p : item) {
                if (product.equals(p.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void emptyBasket() {
        products.clear();
    }

    public List<Product> deleteProduct(String productName) {
        if (!products.containsKey(productName)) {
            System.out.println("Такого продукта нет в корзине");
            return Collections.emptyList();
        }
        List<Product> productsDelete = new ArrayList<>();
        for (List<Product> item : products.values()) {
            Iterator<Product> iterator = item.iterator();
            while (iterator.hasNext()) {
                Product p = iterator.next();
                if (p.getName().equals(productName)) {
                    productsDelete.add(p);
                    iterator.remove();
                }
            }
        }
        return productsDelete;
    }

    public void printProducts(List<Product> products) {
        for (Object item : products) {
            System.out.println(item);
        }
    }
}
