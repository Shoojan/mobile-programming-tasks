package com.example.gridviewdemo.tasks;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

public class SimpleInterest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);
    }

    public void onSimpleInterestCalculateBtnClicked(View view) {
        double principal = Double.parseDouble(((EditText) findViewById(R.id.nameTextView)).getText().toString());
        int time = Integer.parseInt(((EditText) findViewById(R.id.timeEditText)).getText().toString());
        double rate = Double.parseDouble(((EditText) findViewById(R.id.rateEditText)).getText().toString());

        double simpleInterest = (principal * time * rate) / 100;

        TextView simpleInterestTextView = findViewById(R.id.simpleInterestTextView);
        simpleInterestTextView.setText("Interest: " + simpleInterest);
    }
}