package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessageActivity extends AppCompatActivity {

    private TextView text;
    private int Screen = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_area);

        text = findViewById(R.id.score_number);

        Bundle score = getIntent().getExtras();
        String score_text = score.getString("key_score");
        text.setText(score_text);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(DisplayMessageActivity.this, LogoutScreen.class);
                startActivity(intent);
                finish();
            }
        },Screen);

    }
}
