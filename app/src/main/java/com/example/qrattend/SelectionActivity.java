package com.example.qrattend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }


        public void Camerapress(View v1) {
            Intent camerapress = new Intent(this, CameraActivity.class);
            startActivity(camerapress);
        }

        public void Historypress(View v1) {
            Intent historypress = new Intent(this, HistoryActivity.class);
            startActivity(historypress);
        }

        public void Settingspress(View v1) {
            Intent settingspress = new Intent(this, AttendActivity.class);
            startActivity(settingspress);
        }

        public void barscanpress(View v1) {
            Intent barscan = new Intent(this, ScannedBarcodeActivity.class);
            startActivity(barscan);
        }
    }

