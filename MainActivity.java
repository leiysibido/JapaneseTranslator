package com.example.translator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import database.inserting;


public class MainActivity extends AppCompatActivity {

    public EditText pasok;
    public Button translate;
    public TextView labas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pasok=findViewById(R.id.input);
        translate=findViewById(R.id.translate_button);
        labas=findViewById(R.id.output);

        translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseAccess databaseAccess= DatabaseAccess.getInstance(getApplicationContext());
                databaseAccess.open();

                String w = pasok.getText().toString();
                String definition = databaseAccess.getDefinition(w);

                labas.setText(definition);

                databaseAccess.close();
            }
        });

    }

    public void add(View view) {
        Intent intent = new Intent(this, inserting.class);
        startActivity(intent);
    }
}
