package com.lld.calculator.model;

public class BinaryExpression implements Expression{
    Expression left;
    Expression right;
    String operator;

    public BinaryExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public int evaluate() {
        switch (operator){
            case "+" ->  { return left.evaluate()+right.evaluate(); }
            case "-" ->  { return left.evaluate()-right.evaluate(); }
            case "*" ->  { return left.evaluate()*right.evaluate(); }
            case "/" ->  { return left.evaluate()/right.evaluate(); }
        }

        return 0;
    }
}
