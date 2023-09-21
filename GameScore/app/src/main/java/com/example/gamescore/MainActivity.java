package com.example.gamescore;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;
    private TextView button1;
    private TextView button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity","OnCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //       TextView button1 = findViewById(R.id.buttonTeam1);
        //     TextView button2 = findViewById(R.id.button2Team2);
        button1 = findViewById(R.id.buttonTeam1);
        button2 = findViewById(R.id.button2Team2);

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");


            // button1.setText(String.valueOf(score1));
            //button2.setText(String.valueOf(score2));
            updateScore1();
            updateScore2();
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //       Log.d("MainActivity", "clicked tv1");
                //button1.setText(String.valueOf(++score1));
                score1++;
                updateScore1();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Log.d("MainActivity", "clicked tv2");
                //      button2.setText(String.valueOf(++score2));
                score2++;
                updateScore2();
            }
        });
    }

    private void updateScore1() {
        button1.setText(String.valueOf(score1));
    }

    private void updateScore2() {
        button2.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        Log.d("MainActivity","onSaveInstanceState");

        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }

    @Override
    protected void onStart() {

        Log.d("MainActivity","onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d("MainActivity","onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("MainActivity","onDestroy");
        super.onDestroy();
    }


    @Override
    protected void onResume() {
        Log.d("MainActivity","onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity","onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.d("MainActivity","onRestart");
        super.onRestart();
    }
}