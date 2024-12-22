package com.infor.main.stockservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Stock {

    @Id
    private String symbol;  // 주식 종목 코드
    private String name;    // 주식 이름
    private double price;   // 주식 가격
    private double changePercent;  // 상승률

    // getters and setters

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }
}
