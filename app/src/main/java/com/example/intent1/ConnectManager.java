package com.example.intent1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class ConnectManager extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    TextView signUpView;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signUpView = findViewById(R.id.signupText);

        signUpView.setOnClickListener(view -> {
            intent = new Intent(ConnectManager.this, RegistrationActivity.class);
            startActivity(intent);
        });

        loginButton.setOnClickListener(view -> {
            if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                Toast.makeText(ConnectManager.this, "Login Successful!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(ConnectManager.this, "Login Failed!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}