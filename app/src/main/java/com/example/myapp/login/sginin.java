package com.example.myapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class sginin extends Activity {

    private Button buttonsginin;
    private TextView textViewsginup;
    private EditText UserName,Password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sginin);

        initUi();
        ininListener();
    }

    private void initUi() {
        buttonsginin=findViewById(R.id.btnSignIn);
        textViewsginup=findViewById(R.id.tvSignUp);
        UserName=findViewById(R.id.edtUsername);
        Password=findViewById(R.id.edtPassword);
    }

    private void ininListener() {
        //dangnhap
        buttonsginin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSginin();
            }
        });

        //taotaikhoan
        textViewsginup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(sginin.this, sginup.class);
                startActivity(intent);
            }
        });
    }

    private void onClickSginin() {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        String email = UserName.getText().toString().trim();
        String password = Password.getText().toString().trim();
        if(email.equals("")||password.equals("")){
            Toast.makeText(sginin.this, "The email or mobile number you entered is not connected to any account ",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Intent intent = new Intent(sginin.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(sginin.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}

