package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button btCall, btCamera;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCall = findViewById(R.id.appelBtn);
        btCamera = findViewById(R.id.photoBtn);

        btCall.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, CallManager.class);
            startActivity(intent);
        });

        btCamera.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, PhotoManager.class);
            startActivity(intent);
        });

    }
}