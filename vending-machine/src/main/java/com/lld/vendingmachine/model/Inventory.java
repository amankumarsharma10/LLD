package com.lld.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> itemMap = new HashMap<>();
    private Map<String, Integer> stockMap = new HashMap<>();

    public void addItem(String itemCode, Item item, int quantity) {
        itemMap.put(itemCode, item);
        stockMap.put(itemCode, quantity);
    }

    public Item getItem(String itemCode){
        return itemMap.get(itemCode);
    }

    public boolean isAvailable(String itemCode){
        return stockMap.getOrDefault(itemCode,0) > 0;
    }

    public void reduceItem(String itemCode) {
        stockMap.put(itemCode, stockMap.get(itemCode)-1);
    }
}
