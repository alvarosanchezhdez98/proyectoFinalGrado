package com.example.proyectofinalgrado.ui.contact;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.proyectofinalgrado.R;

import java.util.Properties;

public class ContactFragment extends Fragment implements View.OnClickListener {

    private ContactViewModel contactViewModel;
    private final static String emailService = "ponerelnuestro@gmail.com";
    private final static String mailPassword = "Pepito2019";

    EditText editTextPersonFullName;
    EditText editTextEmailAddress;
    EditText editTextDescription;
    Button buttonSubmit;

    //For mail.Using librarires
    Session session;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        contactViewModel =
                ViewModelProviders.of(this).get(ContactViewModel.class);
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        editTextPersonFullName = root.findViewById(R.id.editTextTextPersonFulName);
        editTextEmailAddress = root.findViewById(R.id.editTextTextEmailAddress);
        editTextDescription = root.findViewById(R.id.editTextDescription);
        buttonSubmit = root.findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View view) {
        String userFullName = editTextPersonFullName.getText().toString();
        String userEmailAddress = editTextEmailAddress.getText().toString();
        String userProblemDescription = editTextDescription.getText().toString();

        if(!userFullName.isEmpty() && ! userEmailAddress.isEmpty() && !userProblemDescription.isEmpty()){
            sendEmail(userFullName,userEmailAddress,userProblemDescription);
        }
    }

    private void sendEmail(String user,String email,String message) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

    }
}