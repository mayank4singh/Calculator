package com.example.calculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnClear,btnMultiply,btnDivision,btnPlus,btnMinus,btnDel,btnEqual,btnDot,btnPercent,btnBracket;
    TextView input,output;
    String process;
    Boolean checkBracket = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        btn0 = findViewById(R.id.Btn0);
        btn1 = findViewById(R.id.Btn1);
        btn2 = findViewById(R.id.Btn2);
        btn3 = findViewById(R.id.Btn3);
        btn4 = findViewById(R.id.Btn4);
        btn5 = findViewById(R.id.Btn5);
        btn6 = findViewById(R.id.Btn6);
        btn7 = findViewById(R.id.Btn7);
        btn8 = findViewById(R.id.Btn8);
        btn9 = findViewById(R.id.Btn9);

        btnClear = findViewById(R.id.btnClear);
        btnBracket = findViewById(R.id.btnBracket);
        btnPercent = findViewById(R.id.BtnPercent);

        btnDivision = findViewById(R.id.Btndivision);
        btnMultiply = findViewById(R.id.BtnMultiply);
        btnMinus = findViewById(R.id.BtnMinus);
        btnPlus = findViewById(R.id.BtnPlus);

        btnDel = findViewById(R.id.Btndel);
        btnDot = findViewById(R.id.BtnDot);
        btnEqual = findViewById(R.id.BtnEqual);

        input = findViewById(R.id.Input);
        output = findViewById(R.id.Output);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "9");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "+");
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "-");
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "÷");
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "×");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + ".");
            }
        });

        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                input.setText(process + "%");
            }
        });

        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBracket){
                    process = input.getText().toString();
                    input.setText(process + ")");
                    checkBracket = false;
                }else{
                    process = input.getText().toString();
                    input.setText(process + "(");
                    checkBracket = true;
                }

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();
                process = process.substring(0,process.length()-1);
                input.setText(process);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = input.getText().toString();

                process = process.replaceAll("×","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll("÷","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String FinalResult = "";

                try{
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    FinalResult = rhino.evaluateString(scriptable,process,"",1,null).toString();
                }catch (Exception e){
                    FinalResult ="0";
                }
                output.setText(FinalResult);
            }
        });
        


    }
}
