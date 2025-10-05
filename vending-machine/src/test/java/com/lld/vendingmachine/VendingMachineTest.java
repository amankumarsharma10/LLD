package com.lld.vendingmachine;

import com.lld.vendingmachine.model.Coin;
import com.lld.vendingmachine.model.Item;
import com.lld.vendingmachine.service.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineTest {
    private VendingMachine machine;

    @BeforeEach
    void setup() {
        machine = VendingMachine.getInstance();

        // Load inventory
        machine.getInventory().addItem("A1",new Item("A1", "Chips", 15), 2);
        machine.getInventory().addItem("B2",new Item("B2", "Soda", 20), 1);
    }

    @Test
    void testInsertCoinAndSelectItem_Success() {
        machine.insertCoin(Coin.TEN);
        machine.insertCoin(Coin.FIVE);

        // Select item with exact amount
        machine.selectItem("A1");

        machine.dispense();

        // After dispense, transaction should reset
        assertNull(machine.getTransaction().getSelectedItem(), "Transaction should reset after dispense");
    }

    @Test
    void testInsufficientFunds() {
        machine.insertCoin(Coin.FIVE);
        machine.selectItem("A1");

        // Item should NOT be selected because inserted coins are insufficient
        assertNull(machine.getTransaction().getSelectedItem(),
                "Item should not be selected if insufficient funds");

    }

    @Test
    void testOutOfStock() {
        // Buy Soda once
        machine.insertCoin(Coin.TEN);
        machine.insertCoin(Coin.TEN);
        machine.selectItem("B2");

        // Try again - should be out of stock
        machine.insertCoin(Coin.TEN);
        machine.insertCoin(Coin.TEN);
        machine.selectItem("B2");
        machine.dispense();
        assertFalse(machine.getInventory().isAvailable("B2"), "Soda should be out of stock");
    }
}
