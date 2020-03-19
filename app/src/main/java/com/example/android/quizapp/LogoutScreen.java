package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class LogoutScreen extends AppCompatActivity {

    public Button logout;
    public Button continueButton;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_screen);

        //initialising firebase
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        logout = findViewById(R.id.loginOutButton);
        continueButton = findViewById(R.id.continueButton);

        if(mAuth.getCurrentUser()==null){
            Intent intent = new Intent(LogoutScreen.this, LoginActivity1.class);
            startActivity(intent);
            finish();
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(LogoutScreen.this, LoginActivity1.class);
                Toast.makeText(LogoutScreen.this, "Logged out successfully !!", Toast.LENGTH_LONG).show();
                startActivity(intent);
                finish();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogoutScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
