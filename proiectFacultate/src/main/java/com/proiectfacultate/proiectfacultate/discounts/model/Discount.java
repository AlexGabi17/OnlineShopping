package com.proiectfacultate.proiectfacultate.discounts.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.proiectfacultate.proiectfacultate.users.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "discounts")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long discountId;

    @NotNull
    @Column(name = "name")
    private String name;


    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "percentage")
    private int percentage;

    @NotNull
    @Column(name = "validFrom")
    private LocalDateTime validFrom;

    @NotNull
    @Column(name = "validTo")
    private LocalDateTime validTo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Discount(Long discountId, String name, String description, int percentage, LocalDateTime validFrom, LocalDateTime validTo, User user) {
        this.discountId = discountId;
        this.name = name;
        this.description = description;
        this.percentage = percentage;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.user = user;
    }

    public Discount() {

    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
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

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return percentage == discount.percentage && Objects.equals(discountId, discount.discountId) && Objects.equals(name, discount.name) && Objects.equals(description, discount.description) && Objects.equals(validFrom, discount.validFrom) && Objects.equals(validTo, discount.validTo) && Objects.equals(user, discount.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountId, name, description, percentage, validFrom, validTo, user);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "discountId=" + discountId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", percentage=" + percentage +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                '}';
    }
}
