package org.skypro.skyshop.product;

import org.skypro.skyshop.Search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
        if (productName.isBlank()) {throw new IllegalArgumentException("Название продукта отсутствует");}
        this.productName = productName;
    }

    public String getName() {
        return productName;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial ();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }

    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }


}
