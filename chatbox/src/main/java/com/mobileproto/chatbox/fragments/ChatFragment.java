package com.mobileproto.chatbox.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.mobileproto.chatbox.MainActivity;
import com.mobileproto.chatbox.R;
import com.mobileproto.chatbox.adapters.ChatAdapter;
import com.mobileproto.chatbox.listeners.OnClickListeners;
import com.mobileproto.chatbox.models.Chat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clee2 on 5/31/2014.
 */
public class ChatFragment extends Fragment {
    //List of chats
    ChatAdapter chatAdapter;

    //Context from activity
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_channel, container);
        getChats();
        view = setupViews(view); //Sets up views in this content view.
        return view;
    }

    private View setupViews(View v){
        ListView chatList = (ListView) v.findViewById(R.id.main_chat_list);
        chatList.setAdapter(chatAdapter);

        final EditText input = (EditText) v.findViewById(R.id.main_chat_input);
        input.clearFocus();

        Button sendButton = (Button) v.findViewById(R.id.main_chat_button);
        sendButton.setBackgroundResource(MainActivity.userColors.get(MainActivity.username));
        sendButton.setOnClickListener(OnClickListeners.sendButtonListener(getActivity(), chatAdapter));
        return v;
    }

    private void getChats(){
        //Use content provider in the future
        List<Chat> newChats = new ArrayList<Chat>();
        if (chatAdapter == null)
            chatAdapter = new ChatAdapter(context, new ArrayList<Chat>(), R.layout.chatitem_main);
        chatAdapter.addChats(newChats);
    }
}
