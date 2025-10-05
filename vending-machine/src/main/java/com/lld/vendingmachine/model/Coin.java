package com.lld.vendingmachine.model;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50);

    private final int value; // value in INR

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
