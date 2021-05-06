package com.example.proyectofinalgrado.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinalgrado.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private ProfileViewModel profileViewModel;

    ImageView imageViewUserProfilePic;
    ImageButton imageButtonUserProfilePic;
    TextView textViewUserFullName;
    EditText editTextUserFullName;
    TextView textViewUserBiography;
    EditText editTextUserBiography;
    Button buttonEditProfile;
    Button buttonCancel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        imageViewUserProfilePic = getActivity().findViewById(R.id.imageViewUserProfilePic);
        imageButtonUserProfilePic = getActivity().findViewById(R.id.imageButtonUserProfilePic);
        textViewUserFullName = getActivity().findViewById(R.id.textViewUserFullName);
        editTextUserFullName = getActivity().findViewById(R.id.editTextUserFullName);
        textViewUserBiography = getActivity().findViewById(R.id.textViewUserBiography);
        editTextUserBiography = getActivity().findViewById(R.id.editTextUserBiography);
        buttonEditProfile = getActivity().findViewById(R.id.buttonEditProfile);
        buttonCancel = getActivity().findViewById(R.id.buttonCancel);

        buttonEditProfile.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        imageButtonUserProfilePic.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick(View v) {
        int button = v.getId();
        switch (button){
            case R.id.buttonEditProfile:
                break;
            case R.id.buttonCancel:
                break;
            case R.id.imageButtonUserProfilePic:
                break;
        }
    }
}