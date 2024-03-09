package org.example.model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int price;
    private int category_id;

    public Product() {
    }

    public Product(String name, int quantity, int price, int category_id) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category_id = category_id;
    }

    public Product(int id, String name, int quantity, int price, int category_id) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", category_id=" + category_id +
                '}';
    }
}
