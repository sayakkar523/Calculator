package com.phoneix.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Actions
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQUAL = '=';
    private char current_action = EQUAL;
    private char previous_action;
    // Buttons
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView info;
    private TextView result;
    // Variables
    private double val1 = Double.NaN;
    private double val2 = Double.NaN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + R.string.zero);
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });

        // Calculations
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // val1, action,
                compute(ADDITION);
                result.setText(String.valueOf(val1));
                info.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(SUBTRACTION);
                result.setText(String.valueOf(val1));
                info.setText(null);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(MULTIPLICATION);
                result.setText(String.valueOf(val1));
                info.setText(null);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(DIVISION);
                result.setText(String.valueOf(val1));
                info.setText(null);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute(EQUAL);
                result.setText(String.valueOf(val1) + ", " + String.valueOf(val2));
                info.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

    }


    private void setupUIViews() {
        zero = findViewById(R.id.btn0);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        add = findViewById(R.id.btnadd);
        sub = findViewById(R.id.btnsub);
        mul = findViewById(R.id.btnmul);
        div = findViewById(R.id.btndiv);
        equal = findViewById(R.id.btnequal);
        clear = findViewById(R.id.btnclear);
        info = findViewById(R.id.tvinput);
        result = findViewById(R.id.tvresult);
    }


    private void compute(char action_type) {

//      set action
        previous_action = current_action;
        current_action = action_type;

//      get values
        if (Double.isNaN(val1) && Double.isNaN(val2))
            val1 = Double.parseDouble(info.getText().toString());
        else if (!Double.isNaN(val1) && Double.isNaN(val2))
            val2 = Double.parseDouble(info.getText().toString());

        if (!Double.isNaN(val1) && !Double.isNaN(val2)) {
//      get action
            switch (current_action) {
                case ADDITION:
                    val1 = val1 + val2;
                    val2 = Double.NaN;
                    break;

                case SUBTRACTION:
                    val1 = val1 - val2;
                    val2 = Double.NaN;
                    break;

                case MULTIPLICATION:
                    val1 = val1 * val2;
                    val2 = Double.NaN;
                    break;

                case DIVISION:
                    val1 = val1 / val2;
                    val2 = Double.NaN;
                    break;
            }
            if (current_action == EQUAL) {
                switch (previous_action) {
                    case ADDITION:
                        val1 = val1 + val2;
                        val2 = Double.NaN;
                        break;

                    case SUBTRACTION:
                        val1 = val1 - val2;
                        val2 = Double.NaN;
                        break;

                    case MULTIPLICATION:
                        val1 = val1 * val2;
                        val2 = Double.NaN;
                        break;

                    case DIVISION:
                        val1 = val1 / val2;
                        val2 = Double.NaN;
                        break;
                }
            }
        }

    }

}
