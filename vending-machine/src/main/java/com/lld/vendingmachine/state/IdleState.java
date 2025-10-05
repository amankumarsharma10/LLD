package com.lld.vendingmachine.state;

import com.lld.vendingmachine.model.Coin;
import com.lld.vendingmachine.service.VendingMachine;

public class IdleState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.getTransaction().insertCoin(coin);
        System.out.println("Inserted ₹" + coin.getValue());
        vendingMachine.setState(new HasMoneyState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemCode) {
        System.out.println("Insert coins before selecting item.");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Insert coins and select item first.");
    }

    @Override
    public void refund() {
        System.out.println("Insert coins and select item first.");
    }
}
