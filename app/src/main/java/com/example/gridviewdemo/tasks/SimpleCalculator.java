package com.example.gridviewdemo.tasks;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

public class SimpleCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculator);


        EditText numberText1 = findViewById(R.id.inputNumber1);
        EditText numberText2 = findViewById(R.id.inputNumber2);

        Button addBtn = findViewById(R.id.addBtn);
        Button subtractBtn = findViewById(R.id.subtractBtn);
        Button multiplyBtn = findViewById(R.id.multiplyBtn);
        Button divideBtn = findViewById(R.id.divideBtn);

        TextView resultView = findViewById(R.id.calculatorResultTextView);

        addBtn.setOnClickListener(view -> {
            double number1 = Double.parseDouble(numberText1.getText().toString());
            double number2 = Double.parseDouble(numberText2.getText().toString());
            resultView.setText("Result: " + (number1 + number2));
        });

        subtractBtn.setOnClickListener(view -> {
            double number1 = Double.parseDouble(numberText1.getText().toString());
            double number2 = Double.parseDouble(numberText2.getText().toString());
            resultView.setText("Result: " + (number1 - number2));
        });

        multiplyBtn.setOnClickListener(view -> {
            double number1 = Double.parseDouble(numberText1.getText().toString());
            double number2 = Double.parseDouble(numberText2.getText().toString());
            resultView.setText("Result: " + (number1 * number2));
        });

        divideBtn.setOnClickListener(view -> {
            double number1 = Double.parseDouble(numberText1.getText().toString());
            double number2 = Double.parseDouble(numberText2.getText().toString());
            resultView.setText("Result: " + (number1 / number2));
        });
    }
}