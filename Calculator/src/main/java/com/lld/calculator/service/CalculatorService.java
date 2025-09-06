package com.lld.calculator.service;

import com.lld.calculator.model.Expression;
import com.lld.calculator.parser.ExpressionParser;
import com.lld.calculator.parser.ExpressionTreeBuilder;

import java.util.List;

public class CalculatorService {
    private final ExpressionParser expressionParser = new ExpressionParser();
    private final ExpressionTreeBuilder treeBuilder = new ExpressionTreeBuilder();

    public int evaluate(String expression) {
        List<String> postfix = expressionParser.parse(expression);
        Expression exprTree = treeBuilder.buildExpressionTree(postfix);
        return exprTree.evaluate();
    }
}
