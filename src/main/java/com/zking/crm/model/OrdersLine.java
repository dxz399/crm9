package com.zking.crm.model;

import java.io.Serializable;

public class OrdersLine implements Serializable{
    private Integer oddId;

    private Integer oddOrderId;

    private Integer oddProdId;

    private Integer oddCount;

    private String oddUnit;

    private Float oddPrice;

    @Override
    public String toString() {
        return "OrdersLine{" +
                "oddId=" + oddId +
                ", oddOrderId=" + oddOrderId +
                ", oddProdId=" + oddProdId +
                ", oddCount=" + oddCount +
                ", oddUnit='" + oddUnit + '\'' +
                ", oddPrice=" + oddPrice +
                '}';
    }

    public OrdersLine(Integer oddId, Integer oddOrderId, Integer oddProdId, Integer oddCount, String oddUnit, Float oddPrice) {
        this.oddId = oddId;
        this.oddOrderId = oddOrderId;
        this.oddProdId = oddProdId;
        this.oddCount = oddCount;
        this.oddUnit = oddUnit;
        this.oddPrice = oddPrice;
    }

    public OrdersLine() {
        super();
    }

    public Integer getOddId() {
        return oddId;
    }

    public void setOddId(Integer oddId) {
        this.oddId = oddId;
    }

    public Integer getOddOrderId() {
        return oddOrderId;
    }

    public void setOddOrderId(Integer oddOrderId) {
        this.oddOrderId = oddOrderId;
    }

    public Integer getOddProdId() {
        return oddProdId;
    }

    public void setOddProdId(Integer oddProdId) {
        this.oddProdId = oddProdId;
    }

    public Integer getOddCount() {
        return oddCount;
    }

    public void setOddCount(Integer oddCount) {
        this.oddCount = oddCount;
    }

    public String getOddUnit() {
        return oddUnit;
    }

    public void setOddUnit(String oddUnit) {
        this.oddUnit = oddUnit;
    }

    public Float getOddPrice() {
        return oddPrice;
    }

    public void setOddPrice(Float oddPrice) {
        this.oddPrice = oddPrice;
    }
}