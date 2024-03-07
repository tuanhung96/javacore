package entity;

import utils.FileUtils;

public class Item {
    private int itemId;
    private String name;
    private String category;
    private String price;

    public Item(int itemId, String name, String category, String price) {
        this.itemId = itemId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Item(String name, String category, String price) {
        int lastItemId = FileUtils.getLastItemId();
        if(lastItemId == 0) this.itemId = 1000;
        else this.itemId = lastItemId+1;

        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
