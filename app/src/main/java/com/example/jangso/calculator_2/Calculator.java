package com.example.jangso.calculator_2;

/**
 * Created by Jangso on 2017-06-14.
 */

public class Calculator {
    int i = 0;
    int result;
    int n1,n2;
    //String postfix;
    //InfixToPostfix itp;
    Stack calStack = new Stack(100);
    int calculate(String[] postfix){
        i=0;
        result=0;
        calStack.flush();


        while(postfix[i]!=null){
            switch(postfix[i]){
                case "+":
                    n2 = Integer.parseInt(calStack.pop());
                    n1 = Integer.parseInt(calStack.pop());
                    result = n1+n2;
                    calStack.push(Integer.toString(result));
                    break;
                case "-":
                    n2 = Integer.parseInt(calStack.pop());
                    n1 = Integer.parseInt(calStack.pop());
                    result=n1-n2;
                    calStack.push(Integer.toString(result));
                    break;
                case "*":
                    n2 = Integer.parseInt(calStack.pop());
                    n1 = Integer.parseInt(calStack.pop());
                    result=n1*n2;
                    calStack.push(Integer.toString(result));
                    break;
                case "/":
                    n2 = Integer.parseInt(calStack.pop());
                    n1 = Integer.parseInt(calStack.pop());
                    result = n1/n2;
                    calStack.push(Integer.toString(result));
                    break;
                default:
                    result = Integer.parseInt(postfix[i]);
                    calStack.push(postfix[i]);
            }
            i++;

        }

        return result;
    }
}
