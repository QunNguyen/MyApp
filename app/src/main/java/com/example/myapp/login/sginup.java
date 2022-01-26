package com.example.myapp.login;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapp.MainActivity;
import com.example.myapp.firebase.Firebase;
import com.example.myapp.R;
import com.example.myapp.user.user;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class sginup extends Activity{
    private Button buttonsginup;
    private List<user> list = new ArrayList<>();
    private EditText  editText1,editText2,editText3;
    private  FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sginup);

        initUi();
        ininListener();
    }

    private void initUi() {
        buttonsginup=findViewById(R.id.btnSignUp);

        editText1=findViewById(R.id.edtUsername);
        editText2=findViewById(R.id.edtPassword);
        editText3=findViewById(R.id.edtConfirmPassword);
    }

    private void ininListener() {
        //taotaikhoan
        buttonsginup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateFirebaseAuth();
            }
        });
    }

    private void onCreateFirebaseAuth() {

        String email=editText1.getText().toString().trim();
        String password=editText2.getText().toString().trim();
        String confirmpassword=editText3.getText().toString().trim();

        createNewuser(firebaseAuth.getUid(),email,password,confirmpassword);

    }

    private void createNewuser(String Uid,String email,String password,String confirmpassword) {
        if(validateSgininformEmail(email)&&validateSgininformPassword(password,confirmpassword)){
            new Firebase().writeNewUser(new user(Uid,email,password));


            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Intent intent=new Intent(sginup.this, MainActivity.class);
                                startActivity(intent);
                                finishAffinity();
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(sginup.this,"Faild Sginup",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        if(!validateSgininformEmail(email)){
            Toast.makeText(sginup.this,"Fail Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!validateSgininformPassword(password,confirmpassword)){
            Toast.makeText(sginup.this,"Fail Password",Toast.LENGTH_SHORT).show();
            return;
        }


    }

    public boolean validateSgininformPassword(String password,String confirmpassword){
        if(password.length()<8) return false;
//        if(!(password.matches("(?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16}"))) return false;
        if (!(password.equals(confirmpassword))) return false;
        return true;
    }

    public boolean validateSgininformEmail(String email){
        if(email.equals("")) return false;
        if(!(email.matches("([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?$"))) return false;
        return true;
    }




//    public user createNewuser1(String UID){
//        String username=editText1.getText().toString();
//        String password=editText2.getText().toString();
//        String confirmpassword=editText3.getText().toString();
//
//        return new user(UID,username,password);
//    }

    public void readUser(){
        DatabaseReference mDatabase;
        mDatabase=FirebaseDatabase.getInstance().getReference("users");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    user user=dataSnapshot.getValue(user.class);
                    list.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(sginup.this,"Faild1",Toast.LENGTH_SHORT).show();
            }
        });
    }





}
