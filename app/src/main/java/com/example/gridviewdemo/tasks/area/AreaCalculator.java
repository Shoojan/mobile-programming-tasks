package com.example.gridviewdemo.tasks.area;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

public class AreaCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_calculator);
    }

    public void onAreaCalculateBtnClicked(View view) {
        AreaDialog areaDialog = new AreaDialog();
        areaDialog.show(getSupportFragmentManager(), "Area Calculator");
    }
}