package com.proiectfacultate.proiectfacultate.common.requestModel;

import jakarta.persistence.Column;

import java.util.Objects;

public class ItemRequestModel {

    private String itemName;
    private int price;

    private String description;

    public ItemRequestModel(String itemName, int price, String description) {
        this.itemName = itemName;
        this.price = price;
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemRequestModel that = (ItemRequestModel) o;
        return price == that.price && Objects.equals(itemName, that.itemName) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, price, description);
    }

    @Override
    public String toString() {
        return "ItemRequestModel{" +
                "itemName='" + itemName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
