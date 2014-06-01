package com.mobileproto.chatbox.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileproto.chatbox.MainActivity;
import com.mobileproto.chatbox.R;
import com.mobileproto.chatbox.models.Chat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by clee2 on 5/26/2014.
 */
public class ChatAdapter extends ArrayAdapter {
    private List<Chat> chats = new ArrayList<Chat>();
    private int resource;
    private Context context;

    public ChatAdapter(Context context, List<Chat> chats, int resource) {
        super(context, R.layout.chatitem_main);
        this.context = context;
        this.resource = resource;

        addChats(chats);
    }

    private class ChatHolder {
        TextView name, body, time;
        ImageView picture;
        View background;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        ChatHolder holder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(resource, parent, false);
        holder = new ChatHolder();

        //TextViews
        holder.name = (TextView) view.findViewById(R.id.item_profile_name);
        holder.body = (TextView) view.findViewById(R.id.item_chat_body);
        holder.time = (TextView) view.findViewById(R.id.item_chat_time);

        //ImageViews
        holder.background = view.findViewById(R.id.item_profile_background);
        holder.picture = (ImageView) view.findViewById(R.id.item_profile_picture);
        fillViews(holder, chats.get(position));
        return view;
    }

    @Override
    public int getCount(){
        return this.chats.size();
    }

    private void fillViews(ChatHolder holder, Chat chat){
        holder.name.setText(chat.sender);
        holder.body.setText(chat.body);
        holder.time.setText(formatTime(chat.time));

        holder.background.setBackgroundResource(MainActivity.userColors.get(chat.sender));
        //holder.picture.setImageDrawable(getProfileDrawable(chat.userId));
    }

    private String formatTime(long time){
        if (DateUtils.isToday(time)){
            return new SimpleDateFormat("hh:mm:ss a").format(new Date(time));
        }
        return new SimpleDateFormat("MM/DD, hh:mm:ss a").format(new Date(time));
    }

    private Drawable getProfileDrawable(String id){
        return null;
    }

    public void addChats(List<Chat> newChats){
        this.chats.addAll(newChats);
        notifyDataSetChanged();
    }

    public void addChat(Chat chat){
        this.chats.add(chat);
        notifyDataSetChanged();
    }
}
