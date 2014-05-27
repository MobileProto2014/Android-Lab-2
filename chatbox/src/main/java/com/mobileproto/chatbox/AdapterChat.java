package com.mobileproto.chatbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by clee2 on 5/26/2014.
 */
public class AdapterChat extends ArrayAdapter {
    private List<ModelChat> chats;
    private int resource;
    private Context context;

    public AdapterChat(Context context, List<ModelChat> chats, int resource) {
        super(context, R.layout.chatitem_main);
        this.context = context;
        this.chats = chats;
    }

    private class ChatHolder {
        TextView name, body, time;
        ImageView picture;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ChatHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource, parent, false);
            holder = new ChatHolder();

            //TextViews
            holder.name = (TextView) view.findViewById(R.id.item_profile_name);
            holder.body = (TextView) view.findViewById(R.id.item_chat_body);
            holder.time = (TextView) view.findViewById(R.id.item_chat_time);

            //ImageViews
            holder.picture = (ImageView) view.findViewById(R.id.item_profile_picture);
        } else {
            holder = (ChatHolder) view.getTag();
        }

        fillViews(holder, chats.get(position));

        return view;
    }

    private void fillViews(ChatHolder holder, ModelChat chat){
        holder.name.setText(chat.sender);
        holder.body.setText(chat.body);
        holder.time.setText(formatTime(chat.time));

        holder.picture.setImageDrawable(getProfileDrawable(chat.userId));
    }

    private String formatTime(long time){
        return null;
    }

    private Drawable getProfileDrawable(String id){
        return null;
    }
}
