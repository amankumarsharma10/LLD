package com.lld.calculator;

import com.lld.calculator.model.Expression;
import com.lld.calculator.parser.ExpressionParser;

public class CalculatorExpressionMain {
    public static void main(String[] args) {
        String input = "(3 + 5 ) * 2";

        ExpressionParser parser = new ExpressionParser();
        Expression expr = parser.parse(input);

        System.out.println(expr.evaluate()); // Output: 16
    }
}
