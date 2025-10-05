package com.lld.vendingmachine.model;

import java.util.ArrayList;
import java.util.List;

public class Transaction {
    private final List<Coin> insertedCoins = new ArrayList<>();
    private Item selectedItem;

    public void insertCoin(Coin coin) {
        insertedCoins.add(coin);
    }

    public int getTotalInserted() {
        return insertedCoins.stream().mapToInt(Coin::getValue).sum();
    }

    public void selectItem(Item item) {
        this.selectedItem = item;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void reset(){
        insertedCoins.clear();
        selectedItem = null;
    }
}
