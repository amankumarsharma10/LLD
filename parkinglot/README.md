# 🚗 Parking Lot System (LLD in Java)

A clean, object-oriented **Low-Level Design (LLD)** implementation of a **Parking Lot Management System**, written in **Java**.  
The system demonstrates core software design principles and multiple **Design Patterns** — making it both interview-ready and production-scalable.

## 🧠 Problem Overview

Design a system to manage a parking lot that:
- Handles **multiple floors** and **vehicle types** (Car, Bike, Truck)
- Assigns **available spots** dynamically
- Generates **parking tickets** on entry
- Calculates **fees** on exit
- Uses **extensible strategies** for parking and pricing

## 🧩 System Design Overview

### **Key Components**

| Class             | Description |
|-------------------|-------------|
| `ParkingLot`      | Singleton that manages all floors and gates |
| `ParkingFloor`    | Represents one level in the parking lot |
| `ParkingSpot`     | Represents an individual parking space |
| `Vehicle`         | Base class for all vehicles |
| `Tickets`         | Stores parking information |
| `ParkingStrategy` | Defines how parking spots are allocated |
| `PricingStrategy` | Defines how parking fees are calculated |

## ⚙️ Example Flow

1. **Vehicle Enters**
    - Entry gate finds the nearest available spot.
    - A parking **ticket** is generated.

2. **Vehicle Exits**
    - Exit gate calculates total parking fee based on time and vehicle type.
    - The spot is marked **available** again.