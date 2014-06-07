package com.mobileproto.chatbox.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobileproto.chatbox.MainActivity;
import com.mobileproto.chatbox.R;
import com.mobileproto.chatbox.adapters.ChannelAdapter;
import com.mobileproto.chatbox.models.Channel;

/**
 * Created by clee2 on 6/1/2014.
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        v = fillChannels(v);
        return v;
    }

    private View fillChannels(View v){
        ListView channelList = (ListView) v.findViewById(R.id.fragment_home_channel_list);
        channelList.setAdapter(new ChannelAdapter(getActivity(), R.layout.channelitem_main));
        channelList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((MainActivity)getActivity()).goToChannelFragment(((Channel)view.getTag()).getId());
            }
        });
        return v;
    }
}
