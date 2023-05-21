package com.example.gridviewdemo.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

public class StudentInfoDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info_display);

        Intent intent = getIntent();

        TextView rollNoTextView = findViewById(R.id.rollNoTextView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView genderTextView = findViewById(R.id.genderTextView);
        TextView addressTextView = findViewById(R.id.addressTextView);

        rollNoTextView.setText(intent.getStringExtra("ROLL_NO"));
        nameTextView.setText(intent.getStringExtra("NAME"));
        genderTextView.setText(intent.getStringExtra("GENDER"));
        addressTextView.setText(intent.getStringExtra("ADDRESS"));
    }
}