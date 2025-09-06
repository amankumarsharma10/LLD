package com.lld.calculator.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ExpressionParser {
    //12*(1+4)
    public List<String> parse(String exp){
        List<String> token = tokenize(exp);
        return  infixToPostfix(token);
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

    private  List<String> infixToPostfix(List<String> tokens) {
        List<String> output=new ArrayList<>();
        Stack<String> expStack = new Stack<>();
        Map<String,Integer> precedence=Map.of("+",1,"-",1,"*",2,"/",2);
        for (String token: tokens){
            if(token.matches("\\d+")){
                output.add(token);
            }else {
                if ("+-*/".contains(token)){
                    while (!expStack.isEmpty()
                            && !"(".equals(expStack.peek())
                            && precedence.get(expStack.peek()) >= precedence.get(token)) {
                        output.add(expStack.pop());
                        /*
                            Token "+" Operator
                            and Stack top = "*" (precedence 2)
                            "*" has higher precedence than "+" (1) → pop * first
                            Add * to output
                            Push + to stack
                         */
                    }
                    expStack.push(token);
                } else if ("(".equals(token)) {
                    expStack.push(token);
                } else if(")".equals(token)){
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
}
