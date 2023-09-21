package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextAnswer = findViewById(R.id.editTextAnswer);
        Button buttonAnswer = findViewById(R.id.buttonAnswer);
        TextView textCorrect = findViewById(R.id.textViewCorrectAnswer);
        TextView textIncorrect = findViewById(R.id.textViewIncorrectAnswer);
        TextView textViewExample = findViewById(R.id.textViewExample);

        textViewExample.setText("20 + 7 = ?");

        buttonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text= editTextAnswer.getText().toString();
                int number= Integer.parseInt(text);
                if (text.equals("27")){
                    textCorrect.setVisibility(View.VISIBLE);
                    textIncorrect.setVisibility(View.GONE);
                }else{
                    textIncorrect.setVisibility(View.VISIBLE);
                    textCorrect.setVisibility(View.GONE);
                }

            }
        });

    }
}