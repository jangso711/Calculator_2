package com.example.jangso.calculator_2;

import java.util.StringTokenizer;

/**
 * Created by Jangso on 2017-06-14.
 */

public class InfixToPostfix {
    Stack stk=new Stack(100);
    StringTokenizer st;
    String token;
    String[] postfix= new String[100];
    int i;
    String[] toPostfix(String infix) {
        i=0;
        stk.flush();;
        for(int i = 0;i<100;i++ )
            postfix[i]=null;


        st = new StringTokenizer(infix, "(+-*/)=", true);
        while (st.hasMoreTokens()) {
            token = st.nextToken();
            switch (token) {
                case "+":
                case "-":
                    if (stk.top != -1 && !stk.getTop().equals("(")) {
                        postfix[i++] = stk.pop();
                        System.out.println("pop");
                        stk.push(token);
                        System.out.println("push" + token);
                    } else {
                        stk.push(token);
                        System.out.println("push" + token);
                    }
                    break;
                case "*":
                case "/":
                    if (stk.top!=-1&&(stk.getTop().equals("*") || stk.getTop().equals("/"))) {
                        postfix[i++] = stk.pop();
                        System.out.println("pop");
                        stk.push(token);
                        System.out.println("push" + token);
                    } else {
                        stk.push(token);
                        System.out.println("push" + token);
                    }
                    break;
                case "(":
                    stk.push(token);
                    System.out.println("push" + token);
                    break;
                case ")":
                    while (!stk.getTop().equals("(")) {
                        postfix[i++] = stk.pop();
                    }
                    stk.stk[stk.top--] = null;
                    break;
                case "=":
                    while (stk.top != -1) postfix[i++] = stk.pop();
                    break;
                default:
                    postfix[i++] = token;
                    break;
            }
        }
        return postfix;
    }
}
