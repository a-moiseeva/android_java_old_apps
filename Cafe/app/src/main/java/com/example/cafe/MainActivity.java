package com.example.cafe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUserName;
    private EditText editTextPassword;
    private Button buttonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = editTextUserName.getText().toString().trim();
                String userPassword = editTextPassword.getText().toString().trim();
                if (userName.isEmpty() || userPassword.isEmpty()) {
                    Toast.makeText(
                            MainActivity.this,
                            R.string.error_fields_empty ,
                            Toast.LENGTH_SHORT).show();
                } else {
                    launchNextScreen(userName);
                }
            }
        });
    }
    private void launchNextScreen(String userName){

        Intent intent = MainActivity2.newIntent(this,userName);
        startActivity(intent);
    /*    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("userName", userName);
        startActivity(intent);*/
    }

    private void initViews() {
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonEnter = findViewById(R.id.buttonEnter);
    }
}