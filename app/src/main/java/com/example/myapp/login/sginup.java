package com.example.myapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myapp.Firebase;
import com.example.myapp.MainActivity;
import com.example.myapp.R;
import com.example.myapp.user.user;

public class sginup extends Activity{
    private View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sginup);
        view=(Button) findViewById(R.id.btnSignUp);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new Firebase().writeNewUser("24",new user("2","2","2",2));
            }
        });
    }

    public user createNewuser(){
        String username= view.findViewById(R.id.edtUsername).toString();
        String password=view.findViewById(R.id.edtPassword).toString();
        String fullname=view.findViewById(R.id.edtFullName).toString();
        Integer numberphone=Integer.parseInt(view.findViewById(R.id.edtPhone).toString());
        String confirmpassword=view.findViewById(R.id.edtConfirmPassword).toString();
//        if(checkPassword(password)&&checkConfirmPassword(password,confirmpassword)
//                &&checkNumberPhone(String.valueOf(numberphone))){
//
//        }
        return new user(username,password,fullname,numberphone);
    }

    public boolean checkConfirmPassword(String password,String confirmpassword){
        if (password.equals(confirmpassword)) return true;
        return false;
    }

    public boolean checkPassword(String password){
        if(password.length()<8) return false;
        if(!(password.matches("(?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16}"))) return false;
        return true;
    }
    public boolean checkNumberPhone(String numberphone){
        if(9<numberphone.length()&&numberphone.length()<12) return true;
        return false;
    }

}
