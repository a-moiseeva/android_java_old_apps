package com.example.messenger2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonSendMessage = findViewById(R.id.buttonSendMessage);
        EditText editText = findViewById(R.id.editTextInputMessage);
        buttonSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();

                //другой рабочий вариант (без создания доп метода ланч некст скрин)

/*                Intent intent = new Intent(MainActivity.this, ReceivedMessageActivity.class);
                intent.putExtra("message", message);
                startActivity(intent);*/

                launchNextScreen(message);

            }
        });
    }
    private void launchNextScreen(String message){
        Intent intent = new Intent(this, ReceivedMessageActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);

    }
}