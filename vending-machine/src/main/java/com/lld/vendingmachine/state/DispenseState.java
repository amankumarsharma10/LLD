package com.lld.vendingmachine.state;

import com.lld.vendingmachine.model.Coin;
import com.lld.vendingmachine.model.Item;
import com.lld.vendingmachine.service.VendingMachine;

public class DispenseState implements VendingMachineState{
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Dispensing in progress, cannot insert coins.");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemCode) {
        System.out.println("Already dispensing item.");
    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        Item item = vendingMachine.getTransaction().getSelectedItem();
        if (item == null) {
            System.out.println("No item selected.");
            return;
        }
        vendingMachine.getInventory().reduceItem(item.getItemCode());

        int change = vendingMachine.getTransaction().getTotalInserted() - item.getPrice();
        System.out.println("Dispensed: " + item);
        if (change > 0) {
            System.out.println("Returning change: ₹" + change);
        }

        vendingMachine.getTransaction().reset();
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void refund() {

    }
}
