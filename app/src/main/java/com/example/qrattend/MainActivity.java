package com.example.qrattend;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button login;
Button signup;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
        public void loginbutton(View v1){
            Intent intent1=new Intent(this,ScannedBarcodeActivity.class);
            EditText editText=(EditText)findViewById(R.id.username);
            EditText editText1=(EditText)findViewById(R.id.password);
            String username=editText.getText().toString();
            String pass=editText1.getText().toString();
            boolean flag=false;
            String temp=username;
            int len=username.length();
            for(int i=0;i<len;i++){
                char c=temp.charAt(0);
                if(temp.matches("[a-zA-Z0-9]+")&&!Character.isDigit(c)&&!temp.matches("[ ]+")){
                    flag=true;
                }
                else {
                    flag=false;
                }
            }
            SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("prefkey",0);
            String usernamecheck=sharedPref.getString("Username",null);
            String password=sharedPref.getString("Password",null);
            if(username.equals(usernamecheck)&&pass.equals(password)) {
                flag=true;
            }
            else {
                flag=false;
            }
            if(temp.isEmpty()) {
                Context context = getApplicationContext();
                CharSequence text = "Please Enter a Username";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
            if(flag==true){
                Context context = getApplicationContext();
                CharSequence text = "Login Successful";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                startActivity(intent1);
            }
            else if(flag==false&&!temp.isEmpty()) {
                Context context = getApplicationContext();
                CharSequence text = "Invalid Credentials";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
        public void signupbutton(View v2){
            Intent intent2=new Intent(this,SignupActivity.class);
            startActivity(intent2);
        }
    }
