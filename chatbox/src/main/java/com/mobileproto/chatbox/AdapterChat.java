package com.mobileproto.chatbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by clee2 on 5/26/2014.
 */
public class AdapterChat extends ArrayAdapter {
    private List<ModelChat> chats = new ArrayList<ModelChat>();
    private int resource;
    private Context context;

    public AdapterChat(Context context, List<ModelChat> chats, int resource) {
        super(context, R.layout.chatitem_main);
        this.context = context;
        this.resource = resource;

        addChats(chats);
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

        //holder.picture.setImageDrawable(getProfileDrawable(chat.userId));
    }

    private String formatTime(long time){
        if (DateUtils.isToday(time)){
            return new SimpleDateFormat("HH:mm a").format(new Date(time));
        }
        return new SimpleDateFormat("MM/DD, HH:mm a").format(new Date(time));
    }

    private Drawable getProfileDrawable(String id){
        return null;
    }

    public void addChats(List<ModelChat> newChats){
        this.chats.addAll(newChats);
        Collections.sort(this.chats);
        notifyDataSetChanged();
    }

    public void addChat(ModelChat chat){
        this.chats.add(0, chat);
        notifyDataSetChanged();
    }
}
