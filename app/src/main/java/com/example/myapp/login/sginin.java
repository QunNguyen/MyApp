package com.example.myapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.myapp.R;


public class sginin extends Activity {

    private Button buttonsginin;
    private TextView textViewsginup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sginin);

//        buttonsginin=findViewById(R.id.btnSignIn);
//        buttonsginin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(sginin.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });

        textViewsginup=findViewById(R.id.tvSignUp);
        textViewsginup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sginin.this, sginup.class);
                startActivity(intent);
            }
        });
    }
}

