
package com.example.android.quizapp;

        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

public class ScreenActivity extends AppCompatActivity {
    private int Screen = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ScreenActivity.this, LoginActivity1.class);
                startActivity(intent);
                finish();
            }
        },Screen);
    }
}
