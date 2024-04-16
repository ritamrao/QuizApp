package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class QuizEnd extends AppCompatActivity {
    String name;
    int score;
    TextView nameDisplay;
    TextView scoreDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_end);

        Bundle bundle = getIntent().getExtras();

        name = bundle.getString("name");
        score = bundle.getInt("score");




        nameDisplay = findViewById(R.id.nameDisplay);
        scoreDisplay = findViewById(R.id.scoreDisplay);



        nameDisplay.setText("Congrats " + name);
        scoreDisplay.setText("Score: " + score);


        Button finishButton = findViewById(R.id.finishButton);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizEnd.this, MainActivity.class);
                startActivity(intent);}
        });


        Button restartButton = findViewById(R.id.restartButton);

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizEnd.this, HomePage.class);
                intent.putExtra("name",name);
                startActivity(intent);}
            });

    }
}