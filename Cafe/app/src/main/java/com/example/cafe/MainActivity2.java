package com.example.cafe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private static final String EXTRA_USER_NAME="userName";

    private TextView textViewGreetings;
    private TextView textViewAdditives;

    private RadioGroup radioGroupDrinks;
    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffee;


    private CheckBox checkboxSugar;
    private CheckBox checkboxLemon;
    private CheckBox checkboxMilk;

    private Spinner spinnerTea;
    private Spinner spinnerCoffee;

    private Button buttonMakeOrder;

    private String drink;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        setupUserName();
        radioGroupDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if(id==radioButtonTea.getId()){
                    onUserChoseTea();
                }else if (id==radioButtonCoffee.getId()){
                    onUserChoseCoffee();

                }
            }
        });
        //значение по умолчанию
        radioButtonTea.setChecked(true);

        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onUserMadeOrder();

            }
        });


    }
    private void onUserMadeOrder(){
        ArrayList<String> additives = new ArrayList<>();

        if(checkboxMilk.isChecked()){
            additives.add(checkboxMilk.getText().toString());
        }
        if(checkboxSugar.isChecked()){
            additives.add(checkboxSugar.getText().toString());
        }

        if(radioButtonTea.isChecked() && checkboxLemon.isChecked()){
            additives.add(checkboxLemon.getText().toString());
        }
        String drink = "";

        String drinkType="";
        if (radioButtonTea.isChecked()){
            drinkType=spinnerTea.getSelectedItem().toString();
            drink=getString(R.string.tea);
        } else if (radioButtonCoffee.isChecked()){
            drinkType=spinnerCoffee.getSelectedItem().toString();
            drink=getString(R.string.coffee);
        }
        Intent intent = OrderDetailActivity.newIntent(
                this,
                userName,
                additives.toString(),
                drinkType,
                drink);
        startActivity(intent);
      //  launchNextScreen(userName, additives, drinkType, drink);

    }

    private void launchNextScreen(String userName, String additives, String drinkType,String drink ){
        Intent intent = OrderDetailActivity.newIntent(
                this,
                userName,
                additives,
                drinkType,
                drink);
        startActivity(intent);
    }

    private void onUserChoseTea(){
        drink=getString(R.string.tea);
        String additivesLabel = getString(R.string.addities,drink);
        textViewAdditives.setText(additivesLabel);
        checkboxLemon.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);

    }
    private void onUserChoseCoffee(){
        drink=getString(R.string.coffee);
        String additivesLabel = getString(R.string.addities,drink);
        textViewAdditives.setText(additivesLabel);
        checkboxLemon.setVisibility(View.INVISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);
    }

    private void setupUserName(){
        userName=getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings=getString(R.string.greetings, userName);
        //это изи вариант этого:
      /*  String greetings = getString(R.string.greetings);
        String result=String.format(greetings,userName);*/
        textViewGreetings.setText(greetings);
    }

    private void setupDrink(){
        String userName=getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings=getString(R.string.greetings, userName);
        //это изи вариант этого:
      /*  String greetings = getString(R.string.greetings);
        String result=String.format(greetings,userName);*/
        textViewGreetings.setText(greetings);
    }


    private void initViews() {


        textViewGreetings=findViewById(R.id.textViewGreetings);
        textViewAdditives=findViewById(R.id.textViewAddities);

        radioGroupDrinks=findViewById(R.id.radioGroupDrinks);
        radioButtonTea=findViewById(R.id.radioButtonTea);
        radioButtonCoffee=findViewById(R.id.radioButtonCoffee);


        checkboxSugar=findViewById(R.id.checkboxSugar);
        checkboxLemon=findViewById(R.id.checkboxLemon);
        checkboxMilk=findViewById(R.id.checkboxMilk);

        spinnerTea=findViewById(R.id.spinnerTea);
        spinnerCoffee=findViewById(R.id.spinnerCoffee);

        buttonMakeOrder=findViewById(R.id.buttonMakeOrder);

    }



    public static Intent newIntent(Context context, String userName){
        Intent intent = new Intent(context, MainActivity2.class);
        intent.putExtra(EXTRA_USER_NAME,userName);
        return intent;
    }
}