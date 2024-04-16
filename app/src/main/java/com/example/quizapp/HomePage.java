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


public class HomePage extends AppCompatActivity implements View.OnClickListener{
    String chars;


    TextView totalQuestionsTextView;
    TextView questionTextView;

    Button ansA, ansB, ansC, ansD;
    Button submitBtn, checkBtn;

    int score=0;
    int totalQuestion = QuestionAnswer.question.length;

    int currentQuestionIndex = 0;
    float percentage = 0;
    String selectedAnswer = "";
    Button selectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);
        checkBtn = findViewById(R.id.check_btn);
        selectedButton = submitBtn;
        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        checkBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Progress : "+ percentage);

        loadNewQuestion();




    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.WHITE);
        ansB.setBackgroundColor(Color.WHITE);
        ansC.setBackgroundColor(Color.WHITE);
        ansD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            percentage = (float)((currentQuestionIndex*100)/totalQuestion);
            totalQuestionsTextView.setText("Progress Percentage "+ percentage + "%");
            checkBtn.setVisibility(View.VISIBLE);
            loadNewQuestion();

        }

        else if(clickedButton.getId()==R.id.check_btn){
            checkBtn.setVisibility(View.INVISIBLE);

                String correctAnswer = QuestionAnswer.correctAnswers[currentQuestionIndex];
                selectedButton.setBackgroundColor(Color.RED);
                if (ansA.getText().toString().equals(correctAnswer)) {

                        ansA.setBackgroundColor(Color.GREEN);

                }
                if (ansB.getText().toString().equals(correctAnswer)) {

                        ansB.setBackgroundColor(Color.GREEN);

                }
                if (ansC.getText().toString().equals(correctAnswer)) {

                        ansC.setBackgroundColor(Color.GREEN);

                }
                if (ansD.getText().toString().equals(correctAnswer)) {

                        ansD.setBackgroundColor(Color.GREEN);

                }

        }

        else{
            //choices button clicked
            selectedAnswer  = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
            selectedButton = clickedButton;
        }

    }

    void loadNewQuestion(){

        if(currentQuestionIndex == totalQuestion ){
            endQuiz();
            return;
        }

        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);

    }

    void endQuiz(){
        chars = getIntent().getStringExtra("name");
        Bundle bundle = new Bundle();
        bundle.putString("name", chars);
        bundle.putInt("score", score);
        Intent intent = new Intent(HomePage.this, QuizEnd.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}