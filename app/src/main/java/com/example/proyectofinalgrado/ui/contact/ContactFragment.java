package com.example.proyectofinalgrado.ui.contact;


import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
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

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactFragment extends Fragment implements View.OnClickListener {

    private ContactViewModel contactViewModel;
    private final static String emailService = "asirproyectoredsocial@gmail.com";
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

    private void sendEmail(String user,String email,String messageProblem) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.port","587");

        try{
            session = Session.getDefaultInstance(properties,new Authenticator(){
               @Override
               protected PasswordAuthentication getPasswordAuthentication(){
                   return new PasswordAuthentication(email,mailPassword);
               }
            });

            session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailService,mailPassword);
                }
            });

            if(session!=null){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(emailService));
                message.setSubject("LoopBack");
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
                //message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(emailService));
                message.setContent(messageProblem,"text/html; charset=utf-8");

                Transport.send(message);


            }
        }catch (Exception me){
            Log.i("TAG",me.getMessage());
            Toast.makeText(this.getContext(), "2"+me.getMessage(), Toast.LENGTH_SHORT).show();
            me.printStackTrace();
            //Toast.makeText(this.getContext(), "Could not send email", Toast.LENGTH_SHORT).show();
        }

    }
}