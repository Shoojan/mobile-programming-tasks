package com.example.gridviewdemo.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

public class StudentInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
    }

    public void onStudentInfoDisplayBtnClicked(View view) {
        String rollNo = ((EditText) findViewById(R.id.rollNoEditText)).getText().toString();
        String name = ((EditText) findViewById(R.id.nameEditText)).getText().toString();
        String gender = ((Spinner) findViewById(R.id.genderSpinner)).getSelectedItem().toString();
        String address = ((EditText) findViewById(R.id.addressEditText)).getText().toString();

        Intent intent = new Intent(this, StudentInfoDisplay.class);
        intent.putExtra("ROLL_NO", rollNo);
        intent.putExtra("NAME", name);
        intent.putExtra("GENDER", gender);
        intent.putExtra("ADDRESS", address);
        startActivity(intent);
    }
}