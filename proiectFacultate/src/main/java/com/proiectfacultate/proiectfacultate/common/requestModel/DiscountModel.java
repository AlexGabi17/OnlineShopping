package com.proiectfacultate.proiectfacultate.common.requestModel;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Objects;

public class DiscountModel {


    private String userName;

    private String name;


    private String description;


    private int percentage;



    public DiscountModel(String userName, String name, String description, int percentage) {
        this.userName = userName;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountModel that = (DiscountModel) o;
        return percentage == that.percentage && Objects.equals(userName, that.userName) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, name, description, percentage);
    }

    @Override
    public String toString() {
        return "DiscountModel{" +
                "userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
