package com.example.jangso.calculator_2;

import android.content.Context;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText equation;
    GridLayout keypad;
    InputMethodManager imm;
    Button[] buts = new Button[20];
    InfixToPostfix itp = new InfixToPostfix();
    Calculator cal = new Calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        equation = (EditText) findViewById(R.id.equation);
        keypad = (GridLayout) findViewById(R.id.keypad);

        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        equation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imm.hideSoftInputFromWindow(equation.getWindowToken(), 0);
            }
        });
        for (int i = 0; i < 20; i++){
            buts[i] = (Button) findViewById(R.id.button + i);
            buts[i].setOnClickListener(this);
         }

    }
    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        String input = b.getText().toString();
        int start = equation.getSelectionStart();
        switch(input){
            case "C":
                equation.setText("");
                break;
            case "Del":
                if(start!=0)
                equation.getText().replace(start-1,start,"");
                break;
            case "=":
                equation.append("=");
                int result = cal.calculate(itp.toPostfix(equation.getText().toString()));
                equation.append("\n"+result);
                break;
            default :
                equation.getText().insert(start,input);
                break;
        }


    }
}
