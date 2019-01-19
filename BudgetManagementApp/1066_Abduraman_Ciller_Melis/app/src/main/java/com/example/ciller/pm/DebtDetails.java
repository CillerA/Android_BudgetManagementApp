package com.example.ciller.pm;

import java.io.Serializable;

/**
 * Created by Ciller on 11/30/2017.
 */

public class DebtDetails {
    private String name;
    private String category;
    private String amount;
    private String unit;
    private Integer createdDay;
    private Integer createdMonth;
    private Integer createdYear;
    private Integer dueDay;
    private Integer dueMonth;
    private Integer dueYear;
    private String payment;
    private String description;
    private boolean reminder;


    public DebtDetails(String name, String category, String amount, String unit, Integer createdDay, Integer createdMonth, Integer createdYear, Integer dueDay, Integer dueMonth, Integer dueYear, String payment, String description, boolean reminder) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.unit = unit;
        this.createdDay = createdDay;
        this.createdMonth = createdMonth;
        this.createdYear = createdYear;
        this.dueDay = dueDay;
        this.dueMonth = dueMonth;
        this.dueYear = dueYear;
        this.payment = payment;
        this.description = description;
        this.reminder = reminder;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Integer createdDay) {
        this.createdDay = createdDay;
    }

    public Integer getCreatedMonth() {
        return createdMonth;
    }

    public void setCreatedMonth(Integer createdMonth) {
        this.createdMonth = createdMonth;
    }

    public Integer getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(Integer createdYear) {
        this.createdYear = createdYear;
    }

    public Integer getDueDay() {
        return dueDay;
    }

    public void setDueDay(Integer dueDay) {
        this.dueDay = dueDay;
    }

    public Integer getDueMonth() {
        return dueMonth;
    }

    public void setDueMonth(Integer dueMonth) {
        this.dueMonth = dueMonth;
    }

    public Integer getDueYear() {
        return dueYear;
    }

    public void setDueYear(Integer dueYear) {
        this.dueYear = dueYear;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isReminder() {
        return reminder;
    }

    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "DebtDetails{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", amount='" + amount + '\'' +
                ", unit='" + unit + '\'' +
                ", createdDay=" + createdDay +
                ", creayedMonth=" + createdMonth +
                ", createdYear=" + createdYear +
                ", dueDay=" + dueDay +
                ", dueMonth=" + dueMonth +
                ", dueYear=" + dueYear +
                ", payment='" + payment + '\'' +
                ", description='" + description + '\'' +
                ", reminder=" + reminder +
                '}';
    }
}