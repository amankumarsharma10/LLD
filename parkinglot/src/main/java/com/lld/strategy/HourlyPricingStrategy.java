package com.lld.strategy;

import com.lld.model.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyPricingStrategy implements PricingStrategy{

    @Override
    public double calculate(LocalDateTime entry, LocalDateTime exit, VehicleType type) {
        long hours = Math.max(1, Duration.between(entry, exit).toHours());
        return switch (type) {
            case CAR -> hours * 20;
            case BIKE -> hours * 10;
            case TRUCK -> hours * 50;
        };
    }
}
