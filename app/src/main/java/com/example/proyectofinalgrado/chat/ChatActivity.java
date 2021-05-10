package com.example.proyectofinalgrado.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectofinalgrado.R;

public class ChatActivity extends AppCompatActivity {

    //Interface components
    private ImageView imageViewProfilePic;
    private TextView textViewName;
    private RecyclerView recyclerViewMessages;
    private EditText editTextMessage;
    private Button buttonEnviar;
    private MessageAdapter adapter;
    private ImageButton imageButtonSendPic;

    //Firebase Connections
    //private FirebaseDatabase database;
    //private DatabaseReference databaseReference;
    //private FirebaseStorage storage;
    //private StorageReference storageReference;

    //Checks
    private static final int PHOTO_SEND = 1;
    private static final int PHOTO_PROFILE = 2;
    private String uriProfilePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    private void setScrollBar() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
    }
}