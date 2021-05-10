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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinalgrado.R;

public class ContactFragment extends Fragment implements View.OnClickListener {

    private ContactViewModel contactViewModel;
    private final static String emailService = "ponerelnuestro@gmail.com";

    EditText editTextPersonFullName;
    EditText editTextEmailAddress;
    EditText editTextDescription;
    Button buttonSubmit;

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
        //Set where email will be send.
        String[] to = {emailService};
        String[] cc = {email};

        Intent mailIntent = new Intent(Intent.ACTION_SEND);

        //We prepare the intent to be throw
        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.setType("text/plain");
        mailIntent.putExtra(Intent.EXTRA_EMAIL,to);
        mailIntent.putExtra(Intent.EXTRA_CC, cc);
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, "Problem");
        mailIntent.putExtra(Intent.EXTRA_TEXT,message);

        //Once intent has data we throw it.
        try{
            startActivity(Intent.createChooser(mailIntent,"Sending email"));
        }catch (ActivityNotFoundException cnfe){
            Toast.makeText(this.getActivity(), "Email client doesn't exist", Toast.LENGTH_SHORT).show();
        }
    }
}