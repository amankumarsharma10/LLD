package com.lld.vendingmachine.state;

import com.lld.vendingmachine.model.Coin;
import com.lld.vendingmachine.model.Item;
import com.lld.vendingmachine.service.VendingMachine;

public class HasMoneyState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.getTransaction().insertCoin(coin);//if user want to enter more coins
        System.out.println("Inserted ₹" + coin.getValue() +
                " | Total: ₹" + vendingMachine.getTransaction().getTotalInserted());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String itemCode) {
        if (!vendingMachine.getInventory().isAvailable(itemCode)){
            System.out.println("Item out of stock!");
            return;
        }
        Item item = vendingMachine.getInventory().getItem(itemCode);
        int insertedCoin = vendingMachine.getTransaction().getTotalInserted();

        if (item.getPrice()>insertedCoin){
            System.out.println("Insufficient funds. Insert ₹" + (item.getPrice() - insertedCoin) + " more.");
            return;
        }else {
            vendingMachine.getTransaction().selectItem(item);
            vendingMachine.setState(new DispenseState());
        }

    }

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Cannot dispense. Please select an item first.");
    }

    @Override
    public void refund() {

    }
}
