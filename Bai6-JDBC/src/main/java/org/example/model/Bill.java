package org.example.model;

import java.sql.Date;

public class Bill {
    private int id;
    private int quantity;
    private int price;
    private Date buy_date;
    private int product_id;

    public Bill(int quantity, int price, Date buy_date, int product_id) {
        this.quantity = quantity;
        this.price = price;
        this.buy_date = buy_date;
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(Date buy_date) {
        this.buy_date = buy_date;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
