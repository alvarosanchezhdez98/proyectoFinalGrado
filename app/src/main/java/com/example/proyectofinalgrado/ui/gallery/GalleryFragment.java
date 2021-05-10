package com.example.proyectofinalgrado.ui.gallery;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
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
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.proyectofinalgrado.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private GalleryViewModel galleryViewModel;
    private static final int REQUEST_TAKE_PHOTO =1;
    private static final int RESULT_OK=1;
    private String currentPhotoPath;

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

    }

    private void dispatchTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getActivity().getPackageManager()) !=null){
            File photoFile = null;
            try{
                photoFile = createImagefile();
            }catch(IOException io){
                Toast.makeText(this.getActivity(),"Error al cargar la imagen",Toast.LENGTH_LONG).show();
            }
            if(photoFile !=null){
                Uri photoUri = FileProvider.getUriForFile(this.getActivity(),"com.example.android.fileprovider",photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                startActivityForResult(takePictureIntent,REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //Sustituir por el componente que le toque.
            //imageView.setImageBitmap(imageBitmap);
        }
    }

    /**
     * Create an image and provides name and Path.
     * @return
     * @throws IOException
     */
    private File createImagefile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        //File storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        //Create a tempFile for get image from camera.
        //File image = File.createTempFile(imageFileName,".jpg",storageDirectory);
        //Save the image
        //currentPhotoPath = image.getAbsolutePath();
        //return image;
        return null;
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

    }
}