package com.example.qrattend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    String Radio = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void RadioButton(View v3) {
        boolean checked = ((RadioButton) v3).isChecked();

        // Check which radio button was clicked
        switch (v3.getId()) {
            case R.id.r1:
                if (checked)
                    Radio = "Male";
                break;
            case R.id.r2:
                if (checked)
                    Radio = "Female";
                break;
            case R.id.r3:
                if (checked)
                    Radio = "Other";
                break;


        }
    }

    public void RegisterButton(View v2) {
        Intent mainintent = new Intent(this, MainActivity.class);
        EditText etname = findViewById(R.id.signup_name);
        EditText etage = findViewById(R.id.signup_age);
        EditText etusername = findViewById(R.id.signup_username);
        EditText etpass= findViewById(R.id.signup_password);
        String name = etname.getText().toString();
        String age = etage.getText().toString();
        String usern = etusername.getText().toString();
        String passn = etpass.getText().toString();

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("prefkey", 0);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("Name", name);
        editor.putString("Age",age);
        editor.putString("Username", usern);
        editor.putString("Password", passn);
        editor.putString("Gender", Radio);


        editor.commit();

        RadioButton maleRadioButton, femaleRadioButton, otherRadioButton;

        maleRadioButton = (RadioButton) findViewById(R.id.r1);
        femaleRadioButton = (RadioButton) findViewById(R.id.r2);
        otherRadioButton = (RadioButton) findViewById(R.id.r3);
        boolean check = true;
        String temp = usern;
        int len = usern.length();
        if (name.isEmpty()) {
            check = false;
            Context context = getApplicationContext();
            CharSequence text = "Please Enter a Name";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if (age.isEmpty()) {
            check = false;
            Context context = getApplicationContext();
            CharSequence text = "Please Enter Age";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if (temp.isEmpty()) {
            check = false;
            Context context = getApplicationContext();
            CharSequence text = "Please Enter a Username";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if (passn.isEmpty()) {
            check = false;
            Context context = getApplicationContext();
            CharSequence text = "Please Enter a Password";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else if (!maleRadioButton.isChecked() && !femaleRadioButton.isChecked() && !otherRadioButton.isChecked()) {
            check = false;
            Context context = getApplicationContext();
            CharSequence text = "Please a Select A Gender";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else if ((!temp.matches("[a-zA-Z0-9]+") || Character.isDigit(usern.charAt(0)) || temp.contains(" "))) {
            check = false;
            Context context = getApplicationContext();
            CharSequence text = "Invalid Username";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        if (temp.contains(" ")) {
            check = false;
        }
        if (check == true) {
            Context context = getApplicationContext();
            CharSequence text = "Registered Successfully";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            startActivity(mainintent);
        }
    }
}
