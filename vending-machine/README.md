# 👔 Vending Machine (State Design Pattern)
    The State Design Pattern is a behavioral design pattern that allows an object to change its behavior when its internal state changes.
    Instead of using complex if-else or switch statements to check the current state and decide behavior, the State Pattern delegates the behavior to separate state classes

## Requirements
1. View available products and prices.
2. Select a product.
3. Insert money (different denominations). Support multi-insert.
4. Vend product if enough money and product in stock.
5. Return change if overpaid (minimize number of coins/bills).
6. Cancel transaction and refund inserted money.
7. Maintenance operations: restock product, collect cash, see inventory.

## Entities
    inventory,coins

## Class Diagram:
    VendingmachineDemo
    ---------
    + main()
   
    VendingMachineService
    ---------
    - instance: VendingMachineService
    - currentState: State
    - inventry: Inventry
    - balance: Integer
    + getInstance(): VendingMachineService
    + insertCoin(): void
    + selectItem(): void
    + dispenseItem(): void
    + refund(): Integer


    Item
    ---------
    - itemCode: Integer
    - itemName: String
    - price: Integer
    + getter()
    + setter()

    Inventry
    ---------
    - itemMap : Map<String, Item>


    State (Interface)
    ---------
    + insertCoin() : void
    + pressButton() : void
    + selectItem() : Integer
    + dispenseItem() : Integer
    + refund() : Integer
    
    IdleState
    ---------
    + insertCoin() : void
    + pressButton() : void
    + selectItem() : Integer
    + dispenseItem() : Integer
    + refund() : Integer

    HasCoinState
    ---------
    + insertCoin() : void
    + pressButton() : void
    + selectItem() : Integer
    + dispenseItem() : Integer
    + refund() : Integer

    SelectItemState
    ---------
    + insertCoin() : void
    + pressButton() : void
    + selectItem() : Integer
    + dispenseItem() : Integer
    + refund() : Integer

    DispenseState
    ---------
    + insertCoin() : void
    + pressButton() : void
    + selectItem() : Integer
    + dispenseItem() : Integer
    + refund() : Integer

---
## 🎯 Design Decisions & Patterns

State Pattern → To manage machine states (Idle, HasMoney, Dispensing, OutOfStock)

Strategy Pattern → For change calculation algorithms (Greedy, DP)

Singleton Pattern → For Inventory and CashBox (global unique instances)

Factory Pattern (optional) → For item/coin creation

## 🏗️ High-Level Flow

User inserts coins → Balance updates

User selects item → Check stock & price

Machine validates payment → Dispenses item or error

Returns change (if applicable)

Handles cancel/refund gracefully
