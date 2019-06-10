

package com.example.android.quizapp;

        import android.content.Intent;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

public class LoginActivity1 extends AppCompatActivity {
    private String USERNAMES = "XYZ";
    private String PASSWORDS = "XYZ";

    public EditText usernameText;
    public EditText passwordText;
    public  Button loginButton;
    public  Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login Page");

        setContentView(R.layout.activity_login1);

        usernameText = findViewById(R.id.usernameText);
        passwordText = findViewById(R.id.passwordText);

        loginButton = findViewById(R.id.loginButton);
        resetButton = findViewById(R.id.resetbutton);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameText.setText("");
                passwordText.setText("");
                usernameText.requestFocus();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validation logic

                String username = usernameText.getText().toString();
                String password = passwordText.getText().toString();
                check(username, password);

            }
        });
    }


    private void check(String username, String password) {
        if (username.equals(USERNAMES) && password.equals(PASSWORDS)) {
            Toast.makeText(LoginActivity1.this, "Login Sucessful", Toast.LENGTH_LONG).show();
            Intent move = new Intent(LoginActivity1.this, MainActivity.class);
            startActivity(move);
            finish();
        }
        else {
            Toast.makeText(LoginActivity1.this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }
}