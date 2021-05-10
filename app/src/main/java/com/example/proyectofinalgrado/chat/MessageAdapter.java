package com.example.proyectofinalgrado.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinalgrado.R;
public class MessageAdapter extends RecyclerView.Adapter<MessageHolder> {

    private List<IncomingMessage> messageList = new ArrayList<>();
    private Context c;

    public MessageAdapter(Context c){
        this.c=c;
    }

    public void addMessage(IncomingMessage m){
        messageList.add(m);
        notifyItemInserted(messageList.size());
    }

    @Override
    public MessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(c).inflate(R.layout.card_view_message,parent,false);
        //return new MessageHolder(v);
        return null;
    }

    @Override
    public void onBindViewHolder(MessageHolder holder, int position) {
        //Place Data in components
        holder.getTextViewName().setText(messageList.get(position).getName());
        holder.getTextViewMessage().setText(messageList.get(position).getMessage());
        //We check if there is an image added to the message.
        if(messageList.get(position).getMessageType().equals("2")){
            holder.getImageViewMessagePic().setVisibility(View.VISIBLE);
            holder.getTextViewMessage().setVisibility(View.VISIBLE);
            Glide.with(c).load(messageList.get(position).getUrlPic().into(holder.getImageViewMessagePic()));
        }else if(messageList.get(position).getMessageType().equals("1")){
            holder.getImageViewMessagePic().setVisibility(View.GONE);
            holder.getTextViewMessage().setVisibility(View.VISIBLE);
        }
        //Check if user has a profile pic or we use a default pic.
        if(messageList.get(position).getProfilePic().isEmpty()){
            holder.getImageViewProfilePic().setImageResource(R.drawable.contact);
        }else{
            Glide.with(c).load(messageList.get(position).getProfilePic()).into(holder.getImageViewProfilePic());
        }
        //Get message hour.
        Long timeCode = messageList.get(position).getTime();
        Date date = new Date(timeCode);
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");
        holder.getTextViewTime().setText(format.format(date));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
