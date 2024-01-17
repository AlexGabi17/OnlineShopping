package com.proiectfacultate.proiectfacultate.paymentMethods.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proiectfacultate.proiectfacultate.orders.model.Order;
import com.proiectfacultate.proiectfacultate.users.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "paymentMethods")
public class PaymentMethod {
    public PaymentMethod(Long paymentMethodId, Long cardNumber, String cardUserName, String expirationDate, int cvvNumber, User user) {
        this.paymentMethodId = paymentMethodId;
        this.cardNumber = cardNumber;
        this.cardUserName = cardUserName;
        this.expirationDate = expirationDate;
        this.cvvNumber = cvvNumber;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long paymentMethodId;

    @NotNull
    @Column(name = "cardNumber")
    private Long cardNumber;

    @NotNull
    @Column(name = "cardUserName")
    private String cardUserName;

    @NotNull
    @Column(name = "expirationDate")
    private String expirationDate;

    @NotNull
    @Column(name = "cvvnumber")
    private int cvvNumber;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    @JsonIgnore
    private User user;

    public PaymentMethod() {

    }

    public Long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardUserName() {
        return cardUserName;
    }

    public void setCardUserName(String cardUserName) {
        this.cardUserName = cardUserName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(int cvvNumber) {
        this.cvvNumber = cvvNumber;
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
        PaymentMethod that = (PaymentMethod) o;
        return cardNumber == that.cardNumber && cvvNumber == that.cvvNumber && Objects.equals(paymentMethodId, that.paymentMethodId) && Objects.equals(cardUserName, that.cardUserName) && Objects.equals(expirationDate, that.expirationDate) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethodId, cardNumber, cardUserName, expirationDate, cvvNumber, user);
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "paymentMethodId=" + paymentMethodId +
                ", cardNumber=" + cardNumber +
                ", cardUserName='" + cardUserName + '\'' +
                ", expirationDate=" + expirationDate +
                ", cvvNumber=" + cvvNumber +
                '}';
    }
}
