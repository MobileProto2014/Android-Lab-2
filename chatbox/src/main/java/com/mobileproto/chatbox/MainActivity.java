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
import java.util.List;


public class MainActivity extends Activity {
    //List of chats
    AdapterChat chatAdapter;

    //User Logistics
    public static String username = "default";
    public static String userId = "0001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Sets this activity's content view to the activity_main.xml layout

        getChats();
        setupViews(); //Sets up views in this content view.
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
                //To-do
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
