package com.example.proyectofinalgrado.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
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

    EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextConfirmPassword;
    Button buttonRegister;


    //Firebase authenthication
    FirebaseAuth userAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_register);

        editTextConfirmPassword = findViewById(R.id.editTextConfirmPassword);
        editTextEmail= findViewById(R.id.editTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextUserPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        userAuth  = FirebaseAuth.getInstance();
        buttonRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();
        //Check if all fields have a value
        if(!confirmPassword.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            if(password.equals(confirmPassword)){
                registerUser(email,password);
            }else{
                Toast.makeText(this, "Passwords doesn't match", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Some field is empty",Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Once is checked that fields are not empty.
     * This method try to register the user and show the UID that was generated for him
     * @param email : User Email
     * @param password : User password
     */
    private void registerUser(String email,String password){
        userAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String userId = userAuth.getUid();
                    Toast.makeText(FirebaseRegister.this, "User registered with ID: " + userId, Toast.LENGTH_LONG).show();
                    Intent intentLogin = new Intent(FirebaseRegister.this,FirebaseLogin.class);
                    startActivity(intentLogin);
                }else{
                    Toast.makeText(FirebaseRegister.this, "Email already registered", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}