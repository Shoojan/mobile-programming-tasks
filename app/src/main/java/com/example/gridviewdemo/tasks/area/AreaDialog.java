package com.example.gridviewdemo.tasks.area;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.gridviewdemo.R;

public class AreaDialog extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_area_dialog, container, false);

        EditText lengthEditText = view.findViewById(R.id.lengthEditText);
        EditText breadthEditText = view.findViewById(R.id.breadthEditText);

        Button calculateBtn = view.findViewById(R.id.areaCalculateButton);

        TextView result = view.findViewById(R.id.areaTextView);

        calculateBtn.setOnClickListener(view1 -> {
            Double length = Double.valueOf(lengthEditText.getText().toString());
            Double breadth = Double.valueOf(breadthEditText.getText().toString());

            Double area = length * breadth;
            result.setText("Area: " + area);
        });
        return view;
    }

}
