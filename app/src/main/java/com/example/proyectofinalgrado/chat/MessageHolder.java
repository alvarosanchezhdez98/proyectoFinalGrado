package com.example.proyectofinalgrado.chat;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectofinalgrado.R;

public class MessageHolder extends RecyclerView.ViewHolder{

    private TextView textViewName;
    private TextView textViewMessage;
    private TextView textViewTime;
    private ImageView imageViewProfilePic;
    private ImageView imageViewMessagePic;


    //Param constructor
    public MessageHolder(View itemView){
        super(itemView);
        //textViewName = itemView.findViewById(R.id.textViewName);
        //textViewMessage = itemView.findViewById(R.id.textViewMessage);
        //textViewTime = itemView.findViewById(R.id.textViewTime);
        //imageViewProfilePic = itemView.findViewById(R.id.imageViewProfilePic);
        //imageViewMessagePic = itemView.findViewById(R.id.imageViewMessagePic);
    }

    public TextView getTextViewName() {
        return textViewName;
    }

    public void setTextViewName(TextView textViewName) {
        this.textViewName = textViewName;
    }

    public TextView getTextViewMessage() {
        return textViewMessage;
    }

    public void setTextViewMessage(TextView textViewMessage) {
        this.textViewMessage = textViewMessage;
    }

    public TextView getTextViewTime() {
        return textViewTime;
    }

    public void setTextViewTime(TextView textViewTime) {
        this.textViewTime = textViewTime;
    }

    public ImageView getImageViewProfilePic() {
        return imageViewProfilePic;
    }

    public void setImageViewProfilePic(ImageView imageViewProfilePic) {
        this.imageViewProfilePic = imageViewProfilePic;
    }

    public ImageView getImageViewMessagePic(){
        return this.imageViewMessagePic;
    }

    public void setImageViewMessagePic(ImageView imageViewMessagePic){
        this.imageViewMessagePic = imageViewMessagePic;
    }
}
