package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int price;
    private int discount;

    public DiscountedProduct(String productName, int price, int discount) {
        super(productName);
        if (price <= 0) throw new IllegalArgumentException("Цена отсутствует");
        this.price = price;
        if (discount < 0 | discount > 100) throw new IllegalArgumentException("Неверный диапазон скидки");
        this.discount = discount;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " р. (" + discount + " %)";
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
