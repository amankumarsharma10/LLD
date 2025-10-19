package com.lld.strategy;

import com.lld.model.VehicleType;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculate(LocalDateTime entry, LocalDateTime exit, VehicleType type);

}
