package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
   private int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + ": "+ price +" р.";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
