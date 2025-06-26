package org.skypro.skyshop.product;

public class  FixPriceProduct extends Product {
    private static final int price = 10000;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public String toString() {
        return getName() + ": фиксированная цена " + price +" р.";
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
