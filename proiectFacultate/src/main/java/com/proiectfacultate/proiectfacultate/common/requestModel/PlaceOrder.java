package com.proiectfacultate.proiectfacultate.common.requestModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class PlaceOrder {
    String userName;
    String comments;

    List<Long> itemIds;

    String shipmentCompanyName;

    public PlaceOrder(String userName, String comments, List<Long> itemIds, String shipmentCompanyName) {
        this.userName = userName;
        this.comments = comments;
        this.itemIds = itemIds;
        this.shipmentCompanyName = shipmentCompanyName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }

    public String getShipmentCompanyName() {
        return shipmentCompanyName;
    }

    public void setShipmentCompanyName(String shipmentCompanyName) {
        this.shipmentCompanyName = shipmentCompanyName;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" +
                "userName='" + userName + '\'' +
                ", comments='" + comments + '\'' +
                ", itemIds=" + itemIds +
                ", shipmentCompanyName='" + shipmentCompanyName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceOrder that = (PlaceOrder) o;
        return Objects.equals(userName, that.userName) && Objects.equals(comments, that.comments) && Objects.equals(itemIds, that.itemIds) && Objects.equals(shipmentCompanyName, that.shipmentCompanyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, comments, itemIds, shipmentCompanyName);
    }
}
