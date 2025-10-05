package com.lld.vendingmachine.model;


public class Item {
    private String itemCode;
    private String itemName;
    private Integer price;

    public Item(String itemCode, String itemName, Integer price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                '}';
    }
}
