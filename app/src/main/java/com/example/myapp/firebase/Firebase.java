package com.example.myapp.firebase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapp.R;
import com.example.myapp.user.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Firebase extends Activity {
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void writeNewUser(user user) {
        mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mDatabase.child(String.valueOf(user.getId())).setValue(user);
    }



}
