package com.example.todolist2;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    private EditText editTextNote;
    private RadioButton radioButtonLow;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonHigh;
    private Button buttonSave;

    private Database database = Database.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        initViews();
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNote();
            }
        });

        //значение по умолчанию
       // radioButtonHigh.setChecked(true);
    }


    private void saveNote(){
        String text=editTextNote.getText().toString().trim();
        if(text.isEmpty()){
            Toast.makeText(
                    AddNoteActivity.this,
                    R.string.empty_note_toast ,
                    Toast.LENGTH_SHORT).show();
        } //else {}
        int priority= getPriority();
        int id = database.getNotes().size();
        Note note = new Note(id,text,priority);
        database.add(note);
        finish();
    }

    private int getPriority(){
        int priority;
        if (radioButtonLow.isChecked()) {
            priority = 0;
        } else if (radioButtonMedium.isChecked()){
            priority=1;
        } else{
            priority=2;
        }
        return priority;
    }


    private void initViews(){
        editTextNote=findViewById(R.id.editTextNote);
        radioButtonLow=findViewById(R.id.radioButtonLow);
        radioButtonMedium=findViewById(R.id.radioButtonMedium);
        radioButtonHigh=findViewById(R.id.radioButtonHigh);
        buttonSave=findViewById(R.id.buttonSave);
    }

    public static Intent newIntent(Context context){
        return new Intent(context, AddNoteActivity.class);
    }
}