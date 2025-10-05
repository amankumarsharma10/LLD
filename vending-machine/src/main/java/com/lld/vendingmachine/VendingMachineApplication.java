package com.lld.vendingmachine;


import com.lld.vendingmachine.model.Coin;
import com.lld.vendingmachine.model.Item;
import com.lld.vendingmachine.service.VendingMachine;

public class VendingMachineApplication {

	public static void main(String[] args) {
        VendingMachine machine = VendingMachine.getInstance();

        // Load inventory
        machine.getInventory().addItem("A1", new Item("A1", "Chips", 15), 5);
        machine.getInventory().addItem("B2", new Item("B2", "Soda", 20), 3);
        machine.getInventory().addItem("C3", new Item("C3", "Chocolate", 10), 2);

        // Demo flow
        System.out.println("---- Vending Machine Demo ----");

        machine.insertCoin(Coin.TEN);
        machine.insertCoin(Coin.FIVE);
        machine.selectItem("A1");
        machine.dispense();

        machine.insertCoin(Coin.TEN);
        machine.selectItem("B2");
        machine.dispense();

        machine.insertCoin(Coin.TWO);
        machine.insertCoin(Coin.TWO);
        machine.selectItem("C3");
        machine.dispense();
    }

}
