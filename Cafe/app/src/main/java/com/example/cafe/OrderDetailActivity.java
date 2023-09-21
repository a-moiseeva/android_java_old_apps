package com.example.cafe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {

    private static final String EXTRA_USER_NAME="userName";
    private static final String EXTRA_DRINK_TYPE="drinkType";
    private static final String EXTRA_DRINK  ="drink";
    private static final String EXTRA_ADDITIVES="additives";

    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewType;
    private TextView textViewAddities;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initViews();
        Intent intent=getIntent();
        //String a = intent.getStringExtra(EXTRA_ADDITIVES);
        Log.d("OD","hi");

       // Log.d("OD",a);
        textViewName.setText(intent.getStringExtra(EXTRA_USER_NAME));
        textViewDrink.setText(intent.getStringExtra(EXTRA_DRINK_TYPE));
        textViewType.setText(intent.getStringExtra(EXTRA_DRINK));
        textViewAddities.setText(intent.getStringExtra(EXTRA_ADDITIVES));





    }

    public void initViews(){
        textViewName=findViewById(R.id.textViewName);
        textViewDrink=findViewById(R.id.textViewDrink);
        textViewType=findViewById(R.id.TextViewType);
        textViewAddities=findViewById(R.id.textViewAddities);
    }



    public static Intent newIntent(
            Context context,
            String userName,
            String additives,
            String drinkType,
            String drink){
        Intent intent = new Intent(context, OrderDetailActivity.class);
        //все КЛЮЧИ вынесены в константы
        intent.putExtra(EXTRA_USER_NAME,userName);
        intent.putExtra(EXTRA_DRINK_TYPE,drinkType);
        intent.putExtra(EXTRA_ADDITIVES,additives);
        intent.putExtra(EXTRA_DRINK,drink);
        return intent;
    }
}