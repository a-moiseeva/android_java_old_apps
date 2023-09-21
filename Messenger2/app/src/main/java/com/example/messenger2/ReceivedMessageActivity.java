package com.example.messenger2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivedMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        TextView textViewReceivedMessage = findViewById(R.id.textViewReceivedMessage);
        textViewReceivedMessage.setText(message);

    }
}