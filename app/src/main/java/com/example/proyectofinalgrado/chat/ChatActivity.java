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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    //Interface components
    private  EditText editTextMessage;
    private  FloatingActionButton buttonSendMessage;
    private  ListView listViewMessages;

    private static FirebaseListAdapter adapter;

    //Components of message display model
    private  TextView textViewMessageUser;
    private  TextView textViewMessageTime;
    private  TextView textViewMessageText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editTextMessage = findViewById(R.id.editTextMessageText);
        buttonSendMessage = findViewById(R.id.buttonSendMessage);
        listViewMessages = findViewById(R.id.listViewMessages);

        buttonSendMessage.setOnClickListener(this);
    }

    private void displayMessages(){
        /*adapter = new FirebaseListAdapter<Message>(this,Message.class),
        R.layout.message, FirebaseDatabase.getInstance().getReference(),{
            @Override
            protected void showView(View v;Message modelMessage,int position){
                textViewMessageUser = v.findViewById(R.id.textViewMessageUser);
                textViewMessageTime = v.findViewById(R.id.textViewMessageTime);
                textViewMessageText = v.findViewById(R.id.textViewMessageText);

                //Set the data
                textViewMessageText.setText(modelMessage.getMessageText());
                textViewMessageUser.setText(modelMessage.getMessageUser());

                //Format time data
                textViewMessageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",modelMessage.getMessageTime()));
            }
        };
        //Set the adapter to the listView
        listViewMessages.setAdapter(adapter);*/
    }

    @Override
    public void onClick(View v) {
        //Get Firebase instance
        FirebaseDatabase.getInstance().getReference().push().setValue(new Message(editTextMessage.getText().toString(),
                FirebaseAuth.getInstance().getCurrentUser().getDisplayName()));
        //Clear text componenet
        editTextMessage.setText("");
    }
}