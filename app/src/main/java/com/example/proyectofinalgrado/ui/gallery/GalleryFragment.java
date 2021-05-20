package com.example.proyectofinalgrado.ui.gallery;

import android.Manifest;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private GalleryViewModel galleryViewModel;
    private static final int REQUEST_TAKE_PHOTO =1;
    private static final int RESULT_OK=-1;
    private List<ImageView> lImagenes = new ArrayList<ImageView>();


    private  final String IMAGES_DIRECTORY="images/loopBackImages";
    private String currentPhotoPath;
    File fileImage;
    Bitmap bitmap;


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

        //Ask user for permission
        if(ContextCompat.checkSelfPermission(this.getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this.getActivity(),Manifest.permission.CAMERA)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this.getActivity(),new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA},1000);
        }
        return root;
    }


    @Override
    public void onClick(View view) {
        openCamera();
    }

    private void openCamera(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try{
            startActivityForResult(intentCamera,REQUEST_TAKE_PHOTO);
        }catch (ActivityNotFoundException anfe){
            Toast.makeText(this.getContext(), "Error", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //For add to the gallery
        boolean added=false;
        int i=0;
        if(requestCode == 20){
            MediaScannerConnection.scanFile(this.getContext(), new String[]{currentPhotoPath}, null, new MediaScannerConnection.OnScanCompletedListener() {
                @Override
                public void onScanCompleted(String s, Uri uri) {

                }
            });
            bitmap = BitmapFactory.decodeFile(currentPhotoPath);
            while (!added && i<lImagenes.size()){
                lImagenes.get(i).setImageBitmap(bitmap);
                i++;
                added=true;
            }
        }
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