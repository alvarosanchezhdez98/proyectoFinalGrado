package com.example.proyectofinalgrado.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectofinalgrado.R;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    //Interface components
    private  EditText editTextMessage;
    private  FloatingActionButton buttonSendMessage;
    private  ListView listViewMessages;
    private FirebaseListAdapter<Message> firebaseListAdapter;

    private String dateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);
        editTextMessage = findViewById(R.id.editTextMessageText);

        buttonSendMessage.setOnClickListener(this);
    }

    private void displayMessages(){
        listViewMessages = findViewById(R.id.listViewMessages);
        firebaseListAdapter = new FirebaseListAdapter<Message>(this,Message.class,R.layout.message,FirebaseDatabase.getInstance().getReference()) {
            @Override
            protected void populateView(View v, Message model, int position) {
                //Initialize message layout components
                TextView textViewMessageUser = v.findViewById(R.id.textViewMessageUser);
                TextView textViewMessageTime = v.findViewById(R.id.textViewMessageTime);
                TextView textViewMessageText = v.findViewById(R.id.textViewMessageText);

                textViewMessageUser.setText(model.getMessageUser());
                textViewMessageText.setText(model.getMessageText());
                textViewMessageTime.setText(simpleDateFormat.format(model.getMessageTime()));
            }
        };
        listViewMessages.setAdapter(firebaseListAdapter);
    }

    @Override
    public void onClick(View v) {
        displayMessages();
    }
}