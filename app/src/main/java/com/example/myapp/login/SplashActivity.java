package com.example.myapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextAcivity();
            }
        } ,2000);
    }

    private void nextAcivity() {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null){
            //chua login
            Intent intent=new Intent(this, sginin.class);
            startActivity(intent);
        }
        else {
            //da login
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}