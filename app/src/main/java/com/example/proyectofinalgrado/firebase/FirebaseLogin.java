package com.example.proyectofinalgrado.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalgrado.MainActivity;
import com.example.proyectofinalgrado.R;
import com.example.proyectofinalgrado.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseLogin extends AppCompatActivity implements View.OnClickListener {

    EditText editTextLoginEmail;
    EditText editTextLoginPassword;
    TextView textViewNotRegistered;
    Button buttonLogin;

    //Firebase Connection
    FirebaseAuth userAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_login);

        editTextLoginEmail = findViewById(R.id.editTextLoginEmail);
        editTextLoginPassword = findViewById(R.id.editTextLoginPassword);
        textViewNotRegistered = findViewById(R.id.textViewNotRegistered);
        buttonLogin = findViewById(R.id.buttonLogin);
        userAuth = FirebaseAuth.getInstance();

        buttonLogin.setOnClickListener(this);
        textViewNotRegistered.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id){
            case R.id.buttonLogin:
                loginUser();
                break;
            case R.id.textViewNotRegistered:
                goToRegister();
                break;
        }
    }

    /**
     * Method that start the register page.
     * Active when clicked on not registered yet.
     */
    private void goToRegister() {
        Intent intentRegister = new Intent(this,FirebaseRegister.class);
        startActivity(intentRegister);
    }

    /**
     * Method that tries to log in user.
     */
    private void loginUser() {
        String email=editTextLoginEmail.getText().toString();
        String password=editTextLoginEmail.getText().toString();
        if(!email.isEmpty() && !password.isEmpty()){
            userAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(FirebaseLogin.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                        //Make intent to Main Activity.
                        Intent intentHome = new Intent(FirebaseLogin.this, MainActivity.class);
                    }else{
                        Toast.makeText(FirebaseLogin.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            Toast.makeText(this,"Missing Field",Toast.LENGTH_LONG).show();
        }
    }
}