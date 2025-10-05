package com.lld.vendingmachine.state;

import com.lld.vendingmachine.model.Coin;
import com.lld.vendingmachine.service.VendingMachine;

public interface VendingMachineState {
    void insertCoin(VendingMachine vendingMachine, Coin coin);
    void selectItem(VendingMachine vendingMachine, String itemCode);
    void dispense(VendingMachine vendingMachine);
    void refund();
}
