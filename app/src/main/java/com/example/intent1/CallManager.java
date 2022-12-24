package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CallManager extends AppCompatActivity {

    EditText phoneNo;
    FloatingActionButton callbtn;
    static int PERMISSION_CODE= 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
    }
}