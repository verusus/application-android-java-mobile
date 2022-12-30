package com.example.intent1;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intent1.SQLiteDAO.SQLiteHelper;

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

        SQLiteHelper sqLiteHelper = new SQLiteHelper(this);
        loginButton.setOnClickListener(view -> {

            SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
            String columns[] = {"username", "pass"};
            Cursor cursor = db.query("user", columns, null, null, null, null, null);
//            cursor.moveToFirst();

            boolean isLogged = false;
            while (cursor.moveToNext()) {
                if (username.getText().toString().equals(cursor.getString(0))) {
                    if (password.getText().toString().equals(cursor.getString(1))){
                        isLogged = true;
                        break;
                    }

                }
            }
            if (isLogged)
                Toast.makeText(ConnectManager.this, "Login Successful!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(ConnectManager.this, "Login Failed!", Toast.LENGTH_SHORT).show();



//            if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
//                Toast.makeText(ConnectManager.this, "Login Successful!", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(ConnectManager.this, "Login Failed!", Toast.LENGTH_SHORT).show();
//            }
        });

    }
}