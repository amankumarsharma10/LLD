package com.lld.vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineCoinBox {
    private final Map<Coin, Integer> coins = new HashMap<>();

    public void addCoin(Coin coin) {
        coins.put(coin, coins.getOrDefault(coin, 0) + 1);
    }

    public int getTotalAmount() {
        return coins.entrySet().stream()
                .mapToInt(e -> e.getKey().getValue() * e.getValue())
                .sum();
    }

    public boolean hasChange(int amount) {
        return getTotalAmount() >= amount;
    }

    public void clear() {
        coins.clear();
    }
}
