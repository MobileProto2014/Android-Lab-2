package com.mobileproto.chatbox.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.mobileproto.chatbox.MainActivity;
import com.mobileproto.chatbox.models.Channel;

import java.util.List;

/**
 * Created by clee2 on 6/1/2014.
 */
public class ChannelAdapter extends ArrayAdapter<Channel> {

    private Context context;
    private int resource;

    private List<Channel> channels;

    public ChannelAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.channels = MainActivity.getChannelsForUser(MainActivity.userId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }
        return super.getView(position, convertView, parent);
    }
}
