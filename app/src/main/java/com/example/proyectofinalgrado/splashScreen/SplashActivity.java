package com.example.proyectofinalgrado.splashScreen;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectofinalgrado.MainActivity;
import com.example.proyectofinalgrado.R;
import com.example.proyectofinalgrado.firebase.FirebaseLogin;
import com.example.proyectofinalgrado.firebase.FirebaseRegister;
import com.example.proyectofinalgrado.ui.profile.ProfileFragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Thread that works for 2 seconds.
        //It load the main activity and after 2 seconds, it appears.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //We start loading configuration.
                //ProfileFragment.loadProfilePreferences();
                //Intent intent = new Intent(SplashActivity.this, FirebaseLogin.class);
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}