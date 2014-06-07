package com.mobileproto.chatbox.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mobileproto.chatbox.R;
import com.mobileproto.chatbox.content.ContentManager;
import com.mobileproto.chatbox.models.Channel;

import java.util.List;

/**
 * Created by clee2 on 6/1/2014.
 */
public class ChannelAdapter extends ArrayAdapter<Channel> {

    private Context context;

    private List<Channel> channels;

    public ChannelAdapter(Context context) {
        super(context, R.layout.channelitem_main);
        this.context = context;
        this.channels = ContentManager.getChannelsForUser(ContentManager.userId);
    }

    @Override
    public int getCount() { //Inform the adapter how many items are to be shown
        return this.channels.size();
    }

    @Override
    public Channel getItem(int position) {//Inform the adapter how to get each item
        return this.channels.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChannelHolder holder;
        if (convertView == null) { //View has not been rendered before. Make a new one.
            //Grab the view by inflating the layout file
            convertView = ((Activity) context).getLayoutInflater().inflate(R.layout.channelitem_main, parent, false);

            //Create new view holder to hold these views.
            holder = new ChannelHolder();
            holder.userList = (LinearLayout) convertView.findViewById(R.id.channel_profiles);
            holder.lastChat = (TextView) convertView.findViewById(R.id.channel_mostRecent);
            holder.title = (TextView) convertView.findViewById(R.id.channel_title);
            holder.lastUpdated = (TextView) convertView.findViewById(R.id.channel_lastUpdated);
        } else { //VIew has been rendered before, get the tag of the layout.
            holder = (ChannelHolder) convertView.getTag();
            holder.userList.removeAllViews();
        }
        // Do something with the views (populate them)
        Channel channel = this.channels.get(position); //First grab the information
        holder.title.setText(channel.getName());
        holder.lastChat.setText("placeholder"); // TODO - implement this
        holder.lastUpdated.setText("placeholder"); //TODO - implement this

        /*ImageView profile;
        for (User user : channel.getUsers()) { //TODO - implement Users and channel users
            profile = new ImageView(context); //TODO - make this a network image loaded view
            profile.setImageURI(user.getProfileURI);//TODO - get user profile image URI from image - dependent on image loader
            holder.userList.addView(profile);
        }*/

        return convertView;
    }

    private class ChannelHolder {
        LinearLayout userList;
        TextView lastChat, title, lastUpdated;
    }
}
