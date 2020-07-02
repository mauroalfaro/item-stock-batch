package com.alfarosoft.itemstockbatch.model;

import java.util.Objects;

public class Item {
    private Integer sku;
    private String name;
    private String description;
    private String longDescription;
    private String category;
    private Integer price;
    private String authorizedForSale;

    public Item(Integer sku, String name, String description, String longDescription, String category, Integer price, String authorizedForSale) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.longDescription = longDescription;
        this.category = category;
        this.price = price;
        this.authorizedForSale = authorizedForSale;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAuthorizedForSale() {
        return authorizedForSale;
    }

    public void setAuthorizedForSale(String authorizedForSale) {
        this.authorizedForSale = authorizedForSale;
    }


    @Override
    public String toString() {
        return "Item{" +
                "sku=" + sku +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", authorizedForSale='" + authorizedForSale + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(sku, item.sku) &&
                Objects.equals(name, item.name) &&
                Objects.equals(description, item.description) &&
                Objects.equals(longDescription, item.longDescription) &&
                Objects.equals(category, item.category) &&
                Objects.equals(price, item.price) &&
                Objects.equals(authorizedForSale, item.authorizedForSale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, description, longDescription, category, price, authorizedForSale);
    }
}
