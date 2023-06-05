package com.example.gridviewdemo.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

public class SecretMessageReceiver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secret_message_receiver);
    }


    public void onGetSecretMsgBtnClicked(View view) {
        Intent secretMsgIntent = new Intent(getApplicationContext(), SecretMessage.class);
        startActivityForResult(secretMsgIntent, 222);
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
