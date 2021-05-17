package com.example.proyectofinalgrado.ui.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinalgrado.R;
import com.example.proyectofinalgrado.imageProcessing.ImageCompression;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private GalleryViewModel galleryViewModel;
    private static final int REQUEST_TAKE_PHOTO =1;
    private static final int RESULT_OK=-1;
    private String currentPhotoPath;
    private List<ImageView> lImagenes = new ArrayList<ImageView>();

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
    public void onClick(View view) {
        openCamera();
    }

    private void openCamera(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera,REQUEST_TAKE_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //For add to the gallery
        boolean added=false;
        int i=0;
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap image = (Bitmap) extras.get("data");
            while(!added && i < lImagenes.size()){
                if(lImagenes.get(i).getDrawable()==null){
                    //Reescale the image taken.
                    lImagenes.get(i).setImageBitmap(ImageCompression.reduceBitmapSize(image));
                }
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