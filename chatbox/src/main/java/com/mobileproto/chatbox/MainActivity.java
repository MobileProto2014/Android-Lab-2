package com.mobileproto.chatbox;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends Activity {
    //While Profile Pictures are not implemented
    public static HashMap<String, Integer> userColors = new HashMap<String, Integer>();
    public static List<Integer> colors = Arrays.asList(android.R.color.holo_blue_light,
                                            android.R.color.holo_green_light,
                                            android.R.color.holo_orange_light,
                                            android.R.color.holo_purple,
                                            android.R.color.holo_red_light,
                                            android.R.color.holo_blue_bright,
                                            android.R.color.holo_green_dark,
                                            android.R.color.holo_orange_dark,
                                            android.R.color.holo_red_dark,
                                            android.R.color.holo_blue_dark);

    //List of chats
    AdapterChat chatAdapter;

    //User Logistics
    public static String username = "default";
    public static String userId = "0001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Sets this activity's content view to the activity_main.xml layout

        //Setup colors
        addNewUser(username);

        getChats();
        setupViews(); //Sets up views in this content view.
    }

    public static void addNewUser(String username){
        userColors.put(username, colors.get(userColors.size() % colors.size()));
    }

    private void setupViews(){
        ListView chatList = (ListView) findViewById(R.id.main_chat_list);
        chatList.setAdapter(chatAdapter);

        final EditText input = (EditText) findViewById(R.id.main_chat_input);
        input.clearFocus();

        Button sendButton = (Button) findViewById(R.id.main_chat_button);
        sendButton.setOnClickListener(OnClickListeners.sendButtonListener(this,chatAdapter));
    }

    private void getChats(){
        //Use content provider in the future
        List<ModelChat> newChats = new ArrayList<ModelChat> ();
        if (chatAdapter == null)
            chatAdapter = new AdapterChat(this, new ArrayList<ModelChat>(), R.layout.chatitem_main);
        chatAdapter.addChats(newChats);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.menu_change_username:
                OnClickListeners.changeUsernameListener(this);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
