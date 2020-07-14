package com.alfarosoft.itemstockbatch.model.composites;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Item")
public class ItemComposite {
    @JsonProperty("sku")
    @Id
    @Column(name = "sku")
    private Integer sku;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("description")
    @Column(name = "description")
    private String description;

    @JsonProperty("longDescription")
    @Column(name = "longDescription")
    private String longDescription;

    @JsonProperty("category")
    @Column(name = "category")
    private String category;

    @JsonProperty("price")
    @Column(name = "price")
    private Integer price;


    @JsonProperty("authorizedForSale")
    @Column(name = "authorizedForSale")
    private String authorizedForSale;


    @JsonProperty("dateImported")
    @Column(name = "dateImported")
    private LocalDate dateImported;

    public ItemComposite(){
    }

    public ItemComposite(Integer sku, String name, String description, String longDescription, String category, Integer price, String authorizedForSale, LocalDate dateImported) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.longDescription = longDescription;
        this.category = category;
        this.price = price;
        this.authorizedForSale = authorizedForSale;
        this.dateImported = dateImported;
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

    public LocalDate getDateImported() {
        return dateImported;
    }

    public void setDateImported(LocalDate dateImported) {
        this.dateImported = dateImported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemComposite that = (ItemComposite) o;
        return Objects.equals(sku, that.sku) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(longDescription, that.longDescription) &&
                Objects.equals(category, that.category) &&
                Objects.equals(price, that.price) &&
                Objects.equals(authorizedForSale, that.authorizedForSale) &&
                Objects.equals(dateImported, that.dateImported);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, description, longDescription, category, price, authorizedForSale, dateImported);
    }

    @Override
    public String toString() {
        return "ItemComposite{" +
                "sku=" + sku +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", authorizedForSale='" + authorizedForSale + '\'' +
                ", dateImported=" + dateImported +
                '}';
    }
}
