package com.lld.calculator.parser;

import com.lld.calculator.model.BinaryExpression;
import com.lld.calculator.model.Expression;
import com.lld.calculator.model.NumberExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ExpressionParser {
    //12*(1+4)
    public Expression parse(String exp){
        List<String> token = tokenize(exp);
        List<String> postFixExp = infixToPostfix(token);
        ExpressionTreeBuilder treeBuilder = new ExpressionTreeBuilder();
        return treeBuilder.buildExpressionTree(postFixExp);

    }

    private  List<String> infixToPostfix(List<String> tokens) {
        List<String> output=new ArrayList<>();
        Stack<String> expStack = new Stack<>();
        Map<String,Integer> precedence=Map.of("+",1,"-",1,"*",2,"/",2);
        for (String token: tokens){
            if(token.matches("\\d+")){
                output.add(token);
            }else {
                if ("(+-*/".contains(token)){
                    expStack.push(token);
                }else if(")".equals(token)){
                    while (!expStack.isEmpty() && !expStack.peek().equals("(")){
                        output.add(expStack.pop());
                    }
                    expStack.pop(); // remove '('
                }
            }
        }
        while (!expStack.isEmpty()) {
            output.add(expStack.pop());
        }
        return output;
    }

    private List<String> tokenize(String exp) {
        List<String> tokens = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        for (char ch : exp.toCharArray()) {
            if (Character.isDigit(ch)){
                num.append(ch);
            }else {
                if (!num.isEmpty()) {
                    tokens.add(num.toString());
                    num.setLength(0);
                }
                if("+-*/()".contains(String.valueOf(ch))){
                    tokens.add(String.valueOf(ch));
                }
            }
        }
        if (!num.isEmpty()){
            tokens.add(num.toString());
        }
        return tokens;
    }
}
