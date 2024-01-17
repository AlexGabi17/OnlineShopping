package com.proiectfacultate.proiectfacultate.common.requestModel;

import java.time.LocalDateTime;
import java.util.Objects;

public class SignUpModel {
    private String userName;

    private String password;

    private String role;

    private Long cardNumber;

    private String cardUserName;

    private String expirationDate;

    private int cvvNumber;

    public SignUpModel(String userName, String password, String role, Long cardNumber, String cardUserName, String expirationDate, int cvvNumber) {
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.cardNumber = cardNumber;
        this.cardUserName = cardUserName;
        this.expirationDate = expirationDate;
        this.cvvNumber = cvvNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignUpModel that = (SignUpModel) o;
        return cardNumber == that.cardNumber && cvvNumber == that.cvvNumber && Objects.equals(userName, that.userName) && Objects.equals(password, that.password) && Objects.equals(role, that.role) && Objects.equals(cardUserName, that.cardUserName) && Objects.equals(expirationDate, that.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password, role, cardNumber, cardUserName, expirationDate, cvvNumber);
    }

    @Override
    public String toString() {
        return "signUpModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", cardNumber=" + cardNumber +
                ", cardUserName='" + cardUserName + '\'' +
                ", expirationDate=" + expirationDate +
                ", cvvNumber=" + cvvNumber +
                '}';
    }
}
