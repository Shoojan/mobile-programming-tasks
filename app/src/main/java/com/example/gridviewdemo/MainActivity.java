package com.example.gridviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //Use Linear Layout Manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Specify an adapter
        ExpTaskViewAdapter adapter = new ExpTaskViewAdapter(this, TaskConstants.values());
        recyclerView.setAdapter(adapter);

    }


    // Call Back method  to get the Message form other Activity
    // Receiver
    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed
        if (resultCode == RESULT_OK && requestCode == 222) {
            String secretMsg = data.getStringExtra("SECRET_MESSAGE");
            Toast.makeText(this, "Secret Message: " + secretMsg, Toast.LENGTH_SHORT).show();
        }
    }

}