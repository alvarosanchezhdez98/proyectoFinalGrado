package com.example.proyectofinalgrado.ui.gallery;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinalgrado.R;
import com.example.proyectofinalgrado.imageProcessing.ImageCompression;

import java.io.File;
import java.io.IOException;
import java.security.Permission;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private GalleryViewModel galleryViewModel;
    private static final int REQUEST_TAKE_PHOTO =1;
    private static final int RESULT_OK=-1;
    private List<ImageView> lImagenes = new ArrayList<ImageView>();


    private final String IMAGES_DIRECTORY="images/";
    private final String IMAGE_PATH=IMAGES_DIRECTORY+"loopBack";


    //Gallery ImageViews separated for each row.
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;

    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;

    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;

    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;

    ImageButton imageButtonTakePic;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        linkImageViews(root);
        imageButtonTakePic = root.findViewById(R.id.imageButtonTakePic);
        imageButtonTakePic.setOnClickListener(this);

        return root;
    }


    @Override
    public void onClick(View view)
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            if(ActivityCompat.checkSelfPermission(this.getActivity(),Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                openCamera();
            }else{
                ActivityCompat.requestPermissions(this.getActivity(),new String[]{Manifest.permission.CAMERA},30);
            }
        }else{
            openCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permissions,int[] grantResults) {
        if(requestCode == 30){
            if(permissions.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                openCamera();
            }else{
                Toast.makeText(this.getActivity(), "You need to grant permission", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void openCamera(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera,20);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 20){
            if(resultCode == Activity.RESULT_OK){
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imageView1.setImageBitmap(bitmap);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Links all components
     */
    private void linkImageViews(View root) {
        imageView1 = root.findViewById(R.id.imageView1);
        imageView2 = root.findViewById(R.id.imageView2);
        imageView3 = root.findViewById(R.id.imageView3);
        imageView4 = root.findViewById(R.id.imageView4);
        imageView5 = root.findViewById(R.id.imageView5);
        imageView6 = root.findViewById(R.id.imageView6);
        imageView7 = root.findViewById(R.id.imageView7);
        imageView8 = root.findViewById(R.id.imageView8);
        imageView9 = root.findViewById(R.id.imageView9);
        imageView10 = root.findViewById(R.id.imageView10);
        imageView11 = root.findViewById(R.id.imageView11);
        imageView12 = root.findViewById(R.id.imageView12);
        //Add imageView to the list.
        lImagenes.add(imageView1);
        lImagenes.add(imageView2);
        lImagenes.add(imageView3);
        lImagenes.add(imageView4);
        lImagenes.add(imageView5);
        lImagenes.add(imageView6);
        lImagenes.add(imageView7);
        lImagenes.add(imageView8);
        lImagenes.add(imageView9);
        lImagenes.add(imageView10);
        lImagenes.add(imageView11);
        lImagenes.add(imageView12);
    }
}