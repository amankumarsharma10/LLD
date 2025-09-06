package com.lld.calculator.model;

public class NumberExpression implements Expression{
    int value;

    public NumberExpression(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
