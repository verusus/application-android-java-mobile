package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Button btCall, btCamera, btCalc, btConnect, btContacts;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCall = findViewById(R.id.appelBtn);
        btCamera = findViewById(R.id.photoBtn);
        btCalc = findViewById(R.id.calcBtn);
        btConnect = findViewById(R.id.connectBtn);
        btContacts = findViewById(R.id.btContacts);

        btCall.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, CallManager.class);
            startActivity(intent);
        });

        btCamera.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, PhotoManager.class);
            startActivity(intent);
        });

        btCalc.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, CalcManager.class);
            startActivity(intent);
        });

        btConnect.setOnClickListener(view -> {
            intent = new Intent(MainActivity.this, ConnectManager.class);
            startActivity(intent);
        });

        btContacts.setOnClickListener(view -> {
            intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent);
        });

    }
}