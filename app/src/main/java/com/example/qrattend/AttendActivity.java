package com.example.qrattend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AttendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_attend);
    }
    public void Attend(View v){
        Intent attend_main=new Intent(this,MainActivity.class);
        startActivity(attend_main);
    }
}
