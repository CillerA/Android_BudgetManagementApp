package com.example.ciller.pm;

/**
 * Created by Ciller on 1/17/2018.
 */

public class ReceivableDetails {
    private String name;
    private Integer amount;
    private String unit;
    private Integer id;

    public ReceivableDetails(String name, Integer amount, String unit, Integer id) {
        this.name = name;
        this.amount = amount;
        this.unit = unit;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getUnit() {
        return unit;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ReceivableDetails{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", unit='" + unit + '\'' +
                ", id=" + id +
                '}';
    }
}
