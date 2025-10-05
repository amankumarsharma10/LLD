package com.lld.vendingmachine.service;

import com.lld.vendingmachine.model.Coin;
import com.lld.vendingmachine.model.Inventory;
import com.lld.vendingmachine.model.Transaction;
import com.lld.vendingmachine.model.VendingMachineCoinBox;
import com.lld.vendingmachine.state.IdleState;
import com.lld.vendingmachine.state.VendingMachineState;

public class VendingMachine {
    private static final VendingMachine instance = new VendingMachine();
    private Transaction transaction = new Transaction();
    private VendingMachineState state = new IdleState();
    private VendingMachineCoinBox coinBox = new VendingMachineCoinBox();
    private Inventory inventory = new Inventory();

    private VendingMachine() {
        this.transaction = new Transaction();
        this.state = new IdleState();
        this.coinBox = new VendingMachineCoinBox();
        this.inventory = new Inventory();
    }

    public static VendingMachine getInstance() {
        return instance;
    }

    public void insertCoin(Coin coin) {
        coinBox.addCoin(coin);
        state.insertCoin(this, coin);
    }

    public void selectItem(String itemCode) {
        state.selectItem(this, itemCode);
    }

    public void dispense() {
        state.dispense(this);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public VendingMachineState getState() {
        return state;
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public VendingMachineCoinBox getCoinBox() {
        return coinBox;
    }

    public void setCoinBox(VendingMachineCoinBox coinBox) {
        this.coinBox = coinBox;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
