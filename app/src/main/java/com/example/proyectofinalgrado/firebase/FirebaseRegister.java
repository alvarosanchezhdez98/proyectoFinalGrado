package com.example.proyectofinalgrado.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectofinalgrado.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseRegister extends AppCompatActivity implements View.OnClickListener {

    EditText editTextUserName;
    EditText editTextEmail;
    EditText editTextPassword;
    Button buttonRegister;


    //Firebase authenthication
    FirebaseAuth userAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_register);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextEmail= findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextUserPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        userAuth  = FirebaseAuth.getInstance();
        buttonRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String userName = editTextUserName.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        //Check if all fields have a value
        if(!userName.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            userAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        String userId = userAuth.getUid();
                        Toast.makeText(FirebaseRegister.this, "User registered with ID: " + userId, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }else{
            Toast.makeText(this,"Some field is empty",Toast.LENGTH_LONG).show();
        }
    }
}