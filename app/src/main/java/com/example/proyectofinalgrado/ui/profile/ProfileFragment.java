package com.example.proyectofinalgrado.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinalgrado.R;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private ProfileViewModel profileViewModel;

    //For take photo from gallery
    private static final int RESULT_OK=1;

    //Components
    ImageView imageViewUserProfilePic;
    ImageButton imageButtonUserProfilePic;
    TextView textViewUserFullName;
    EditText editTextUserFullName;
    TextView textViewUserBiography;
    EditText editTextUserBiography;
    Button buttonEditProfile;
    Button buttonCancel;

    //User data.
    private String fullName;
    private String biography;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        imageViewUserProfilePic = root.findViewById(R.id.imageViewUserProfilePic);
        imageButtonUserProfilePic = root.findViewById(R.id.imageButtonUserProfilePic);
        textViewUserFullName = root.findViewById(R.id.textViewUserFullName);
        editTextUserFullName = root.findViewById(R.id.editTextUserFullName);
        textViewUserBiography = root.findViewById(R.id.textViewUserBiography);
        editTextUserBiography = root.findViewById(R.id.editTextUserBiography);
        buttonEditProfile = root.findViewById(R.id.buttonEditProfile);
        buttonCancel = root.findViewById(R.id.buttonCancel);

        buttonEditProfile.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        imageButtonUserProfilePic.setOnClickListener(this);


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        int button = v.getId();
        switch (button){
            case R.id.buttonEditProfile:
                editProfile();
                break;
            case R.id.buttonCancel:
                cancelChanges();
                break;
            case R.id.imageButtonUserProfilePic:
                changeProfilePic();
                break;
        }
    }

    /**
     * Open gallery and once the image is set turn on an ImageView.
     */
    private void changeProfilePic() {
        Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        //startActivityForResult(intentGallery,PICK_IMAGE);
        startActivityForResult(intentGallery.createChooser(intentGallery,"Seleccione una aplicacion"),10);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Uri imagePath = data.getData();
            imageButtonUserProfilePic.setImageURI(imagePath);
        }
    }

    /**
     * This method is only callable if editProfille is called.
     * Change visibility of edit componenets to gone and keep the original data.
     *
     */
    private void cancelChanges() {
        textViewUserFullName.setText(fullName);
        textViewUserBiography.setText(biography);
        buttonEditProfile.setText("Edit Profile");

        //Clear Edit Components
        imageButtonUserProfilePic.setVisibility(View.GONE);
        editTextUserFullName.setVisibility(View.GONE);
        editTextUserBiography.setVisibility(View.GONE);
        buttonCancel.setVisibility(View.GONE);

        imageButtonUserProfilePic.setClickable(false);
        editTextUserFullName.setClickable(false);
        editTextUserBiography.setClickable(false);
        buttonCancel.setClickable(false);

        imageViewUserProfilePic.setVisibility(View.VISIBLE);
        textViewUserFullName.setVisibility(View.VISIBLE);
        textViewUserBiography.setVisibility(View.VISIBLE);
    }

    /**
     * Get data from Visual Components and make them Gone.
     * Edit components go visible and appears with original data.
     * Also appears a button to cancel edits.
     * @Link: cancelChanges()
     * Own button change to save and make the reverse operation.
     */
    private void editProfile() {
        if(buttonEditProfile.getText().toString().equals("Edit Profile")){
            //Initialize variables with data
            fullName = textViewUserFullName.getText().toString();
            biography = textViewUserBiography.getText().toString();

            //Settings editText with designed options.
            buttonEditProfile.setText("Save");
            imageButtonUserProfilePic.setImageDrawable(imageViewUserProfilePic.getDrawable());
            editTextUserFullName.setText(fullName);
            editTextUserBiography.setText(biography);

            //Clear original components
            imageViewUserProfilePic.setVisibility(View.GONE);
            textViewUserFullName.setVisibility(View.GONE);
            textViewUserBiography.setVisibility(View.GONE);

            //Make visible and clickable edit components
            imageButtonUserProfilePic.setVisibility(View.VISIBLE);
            editTextUserFullName.setVisibility(View.VISIBLE);
            editTextUserBiography.setVisibility(View.VISIBLE);
            buttonCancel.setVisibility(View.VISIBLE);

            imageButtonUserProfilePic.setClickable(true);
            editTextUserFullName.setClickable(true);
            editTextUserBiography.setClickable(true);
            buttonCancel.setClickable(true);
        }else if(buttonEditProfile.getText().toString().equals("Save")){
            fullName = editTextUserFullName.getText().toString();
            biography = editTextUserBiography.getText().toString();
            if(!fullName.isEmpty() && !biography.isEmpty()){
                imageViewUserProfilePic.setImageDrawable(imageButtonUserProfilePic.getDrawable());
                textViewUserFullName.setText(fullName);
                textViewUserBiography.setText(biography);
                buttonEditProfile.setText("Edit Profile");

                //Make Invisible and non clickable edit components
                imageButtonUserProfilePic.setVisibility(View.GONE);
                editTextUserFullName.setVisibility(View.GONE);
                editTextUserBiography.setVisibility(View.GONE);
                buttonCancel.setVisibility(View.GONE);

                imageButtonUserProfilePic.setClickable(false);
                editTextUserFullName.setClickable(false);
                editTextUserBiography.setClickable(false);
                buttonCancel.setClickable(false);

                //Make text and image components visible again.
                imageViewUserProfilePic.setVisibility(View.VISIBLE);
                textViewUserFullName.setVisibility(View.VISIBLE);
                textViewUserBiography.setVisibility(View.VISIBLE);
            }
        }
    }
}