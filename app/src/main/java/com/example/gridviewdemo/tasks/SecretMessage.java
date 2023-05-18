package com.example.gridviewdemo.tasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gridviewdemo.R;

public class SecretMessage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secret_message);
    }

    public void onSecretMessageBtnClicked(View view) {
        String secretMsg = ((EditText) findViewById(R.id.secretMsg)).getText().toString();

        Intent intent = new Intent();
        intent.putExtra("SECRET_MESSAGE", secretMsg);
        setResult(RESULT_OK, intent);
        finish();
    }
}