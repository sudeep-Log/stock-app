package com.app.stockapp.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "Stock")
public class Stock {

    @Id
    private String symbol;

    private String sector;

    private Integer quantity;

    private Double averagePrice;


    public Stock(String symbol, String sector, Integer quantity, Double averagePrice) {
        this.symbol = symbol;
        this.sector = sector;
        this.quantity = quantity;
        this.averagePrice = averagePrice;
    }

    public Stock() {
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }
}
