package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button startButton = findViewById(R.id.buttonStart);


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameEdittext = findViewById(R.id.editTextTextPersonName);
                String name = nameEdittext.getText().toString();

                Intent intent = new Intent(MainActivity.this, HomePage.class);

                intent.putExtra("name",name);
                startActivity(intent);}
        });

    }

}