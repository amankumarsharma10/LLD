package com.lld.calculator.parser;

import com.lld.calculator.model.BinaryExpression;
import com.lld.calculator.model.Expression;
import com.lld.calculator.model.NumberExpression;

import java.util.List;
import java.util.Stack;

public class ExpressionTreeBuilder {
    public Expression buildExpressionTree(List<String> postfix) {
        Stack<Expression> stack = new Stack<>();
        for (String token: postfix){
            if ((token.matches("\\d"))){
                stack.push(new NumberExpression(Integer.parseInt(token)));
            }else {
                var left = stack.pop();
                var right = stack.pop();
                stack.push(new BinaryExpression(left,right,token));
            }
        }
        return stack.pop();
    }
}
