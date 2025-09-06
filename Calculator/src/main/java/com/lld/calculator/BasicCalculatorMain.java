package com.lld.calculator;

import com.lld.calculator.model.BinaryExpression;
import com.lld.calculator.model.Expression;
import com.lld.calculator.model.NumberExpression;

public class BasicCalculatorMain {
    public static void main(String[] args) {
        // 4*(1+7)
        Expression number1 = new NumberExpression(4);
        Expression number2 = new NumberExpression(1);
        Expression number3 = new NumberExpression(7);

        Expression expression  = new BinaryExpression(number1,new BinaryExpression(number2,number3,"+"),"*");
        System.out.println(expression.evaluate());
    }
}
