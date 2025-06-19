package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int price;
    private int discount;

    public DiscountedProduct(String productName, int price, int discount) {
        super(productName);
        this.price = price;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return getProductName() + ": "+ getPrice() +" р. ("+ discount +" %)";
    }

    @Override
    public int getPrice() {
        return price - price * discount / 100;
    }

     @Override
    public boolean isSpecial() {
        return true;
    }
}
