package com.example.jangso.calculator_2;

/**
 * Created by Jangso on 2017-06-14.
 */

public class Stack {
    String[] stk;
    int stackSize;
    int top = -1;
    String temp;
    Stack(int size){
        stk = new String[size];
        stackSize = size;
    }
    String pop(){
        if(top!=-1){ //Stack empty test
            temp = stk[top];
            stk[top--] = null;
            return temp;
        }
        else
            return "Stack is Empty";
    }
    void push(String data){
        if(top!=stackSize-1) //Stack full test
            stk[++top] = data;
    }
    String getTop(){
        if(top!=-1)
            return stk[top];
        else
            return null;
    }
    void flush(){
        for(int i = 0;i<stk.length;i++)
            stk[i]=null;
    }
}
