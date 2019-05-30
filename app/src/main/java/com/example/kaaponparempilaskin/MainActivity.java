package com.example.kaaponparempilaskin;

import android.app.Activity;
import android.os.Bundle;

import expression.Expression;
import expression.SymbolTable;
import math.fraction.fraction.Fraction;
import math.fraction.fraction.Fractionable;
import operator.binaryoperator.BinaryOperator;
import operator.genericoperator.GenericOperatorGroup;
import operator.genericoperator.GenericOperatorStack;
import operator.genericoperator.OperatorType;
import parser.ExpressionParser;
import parser.MyValueProvider;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GenericOperatorStack operatorStack = new GenericOperatorStack(
                new GenericOperatorGroup(
                        OperatorType.UNARY,
                        Expression.operatorEll,
                        Expression.operatorFac
                ),

                new GenericOperatorGroup(
                        OperatorType.UNARY,
                        Expression.operatorAbs,
                        Expression.operatorParen
                ),

                new GenericOperatorGroup(OperatorType.BINARY, Expression.operatorAdd, Expression.operatorSub),
                new GenericOperatorGroup(OperatorType.BINARY, Expression.operatorMul, Expression.operatorDiv),
                new GenericOperatorGroup(OperatorType.UNARY,  Expression.operatorNeg, Expression.operatorPos),
                new GenericOperatorGroup(OperatorType.BINARY, Expression.operatorPow, Expression.operatorIPo),
                new GenericOperatorGroup(OperatorType.BINARY, Expression.operatorRot, Expression.operatorIRo),

                new GenericOperatorGroup(OperatorType.UNARY,  Expression.operatorSqr, Expression.operatorISq,
                        Expression.operatorSin, Expression.operatorCos,
                        Expression.operatorTan, Expression.operatorL10,
                        Expression.operatorLo2, Expression.operatorLon)

        );

        ExpressionParser<Fraction> parser = new ExpressionParser<Fraction>("1 + 2", new MyValueProvider<Fraction>(), operatorStack, (BinaryOperator) Expression.operatorMul, SymbolTable.defaultTable, false);
    }
}
