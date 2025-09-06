package com.lld.calculator;

import com.lld.calculator.service.CalculatorService;

public class CalculatorExpressionMain {
    public static void main(String[] args) {
        String input = "(3 + 5 ) * 2";

        CalculatorService calculator = new CalculatorService();
        System.out.println(calculator.evaluate("(3 + 5) * 2"));  // 16
        System.out.println(calculator.evaluate("3 + 4 * 2"));

    }
}
