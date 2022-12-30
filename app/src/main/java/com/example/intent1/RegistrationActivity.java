package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intent1.SQLiteDAO.SQLiteHelper;

public class RegistrationActivity extends AppCompatActivity {

    EditText username, password, passwordValidation;
    Button register;
    TextView signUp;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        register = findViewById(R.id.registerButton);
        signUp = findViewById(R.id.signupText);

        register.setOnClickListener(view -> {
            // if the button clicked then start grabbing the following data
            username = findViewById(R.id.username);
            password = findViewById(R.id.password);
            passwordValidation = findViewById(R.id.passwordValidation);

            if (password.getText().toString().equals(passwordValidation.getText().toString())){
                //creating the database helper to manipulate the database
                SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
                SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("username", username.getText().toString());
                contentValues.put("pass", password.getText().toString());
                long r = db.insert("user", null, contentValues);
                if (r!=-1)
                    Toast.makeText(RegistrationActivity.this, "You are registered successfully!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RegistrationActivity.this, "There was a problem!", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(RegistrationActivity.this, "The passwords doesn't match!", Toast.LENGTH_SHORT).show();

            }
        });

        signUp.setOnClickListener(view -> {
            intent = new Intent(RegistrationActivity.this, ConnectManager.class);
            startActivity(intent);
        });

    }
}