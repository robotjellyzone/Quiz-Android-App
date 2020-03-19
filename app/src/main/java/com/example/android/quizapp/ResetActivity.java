package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ResetActivity extends AppCompatActivity {

    public EditText emailId;
    public Button resetpass;
    public Button loginButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        //initialising firebase
        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        emailId = findViewById(R.id.email_id);
        resetpass = findViewById(R.id.resetPassword);
        loginButton = findViewById(R.id.loginBtn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResetActivity.this, LoginActivity1.class);
                startActivity(intent);
                finish();
            }
        });

        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(ResetActivity.this, "Please enter you email id", Toast.LENGTH_LONG).show();
                } else {
                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(ResetActivity.this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ResetActivity.this, "Reset Link Sent to email !", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(ResetActivity.this, "Unable to send reset mail!", Toast.LENGTH_LONG).show();
                            }
                        }

                    });

                }
            }
        });


    }
}
