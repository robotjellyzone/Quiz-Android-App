package com.example.android.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

    public class MainActivity extends AppCompatActivity {
        private QuestionArea questions = new QuestionArea();

        private TextView score_view;
        private TextView question_view;
        private Button Choice1;
        private Button Choice2;
        private Button Choice3;
        private Button Choice4;
        private String Answer;
        private TextView numberOfTheQuestion;
        private int Score = 0;
        private int qn = 1;
        private int QuestionNumber  = 0;
        public ImageButton nextquestion;
        public ImageButton previousquestion;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            score_view = (TextView)findViewById(R.id.score_result);
            question_view = findViewById(R.id.question);
            numberOfTheQuestion = findViewById(R.id.question_number);
            Choice1 = findViewById(R.id.choice1);
            Choice2 = findViewById(R.id.choice2);
            Choice3 = findViewById(R.id.choice3);
            Choice4 = findViewById(R.id.choice4);
            nextquestion = findViewById(R.id.next_question);

            updateQuestion();

            Choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Choice1.getText() == Answer){
                        Score ++;
                        qn++;
                        updateScore(Score);
                        updateQuestion();
                        //Toast if correct answer
                        Toast.makeText(MainActivity.this, "Awesome!!!", Toast.LENGTH_LONG).show();}
                    //Toast if wrong answer
                    else{
                        updateQuestion();
                        Toast.makeText(MainActivity.this, "Oops!!, You got it wrong", Toast.LENGTH_LONG).show();
                    }
                }
            });
            Choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Choice2.getText() == Answer){
                        Score++;
                        qn++;
                        updateScore(Score);
                        updateQuestion();
                        //If correct
                        Toast.makeText(MainActivity.this, "Good job!!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        updateQuestion();
                        Toast.makeText(MainActivity.this, "Oops!!, You got it wrong", Toast.LENGTH_LONG).show();
                    }
                }
            });

            Choice3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Choice3.getText() == Answer){
                        Score++;
                        qn++;
                        updateScore(Score);
                        updateQuestion();
                        Toast.makeText(MainActivity.this, "Great Job!!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        updateQuestion();
                        Toast.makeText(MainActivity.this, "Oops!!, You got it wrong", Toast.LENGTH_LONG).show();
                    }
                }
            });


            Choice4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(Choice4.getText() == Answer){
                        Score++;
                        qn++;
                        updateScore(Score);
                        updateQuestion();
                        //If correct
                        Toast.makeText(MainActivity.this, "Amazing!!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        updateQuestion();
                        Toast.makeText(MainActivity.this, "Oops!!, You got it wrong", Toast.LENGTH_LONG).show();
                    }
                }
            });



        }

        private void setTitleColor() {
        }


        private void updateQuestion(){
            if( QuestionNumber !=5){
                question_view.setText(questions.getQuestions(QuestionNumber));
                Choice1.setText(questions.getchoice1(QuestionNumber));
                Choice1.setTextColor(Color.WHITE);
                Choice2.setText(questions.getchoice2(QuestionNumber));
                Choice2.setTextColor(Color.WHITE);
                Choice3.setText(questions.getchoice3(QuestionNumber));
                Choice3.setTextColor(Color.WHITE);
                Choice4.setText(questions.getchoice4(QuestionNumber));
                Choice4.setTextColor(Color.WHITE);

                Answer = questions.getCorrectAnswer(QuestionNumber);
                QuestionNumber++;
                numberOfTheQuestion.setText("Question: -"+ QuestionNumber);
            }
            else{
                String score_string = "" + Score;
                Intent result = new Intent(MainActivity.this, DisplayMessageActivity.class);
                Bundle score = new Bundle();
                score.putString("key_score", score_string);
                result.putExtras(score);
                startActivity(result);
                finish();

            }
        }

        private void updateScore(int points){
            score_view.setText("" + Score);
        }

        public void next_question(View view) {

            if(QuestionNumber ==4){
            }
            if(QuestionNumber == 5){

                String score_string = "" + Score;
                Intent result = new Intent(MainActivity.this, DisplayMessageActivity.class);
                Bundle score = new Bundle();
                score.putString("key_score", score_string);
                result.putExtras(score);
                startActivity(result);
                finish();
            }
            else{
                updateQuestion();
            }
        }

        public void previous_question(View view) {
            if(QuestionNumber != 1){

                QuestionNumber-=2;
                updateQuestion();
            }
            else{
                Toast.makeText(MainActivity.this,"Cannot go Back",Toast.LENGTH_SHORT).show();
            }
        }
    }

