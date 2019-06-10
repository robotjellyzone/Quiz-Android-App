package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_area);

        text = findViewById(R.id.score_number);

        Bundle score = getIntent().getExtras();
        String score_text = score.getString("key_score");
        text.setText(score_text);

    }
}
