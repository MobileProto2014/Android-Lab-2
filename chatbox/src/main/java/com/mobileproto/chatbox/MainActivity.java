package com.mobileproto.chatbox;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {
    //List of chats
    AdapterChat chatAdapter;

    //User Logistics
    String username;

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
    }

    private void getChats(){
        List<ModelChat> newChats = Arrays.asList(
                new ModelChat("Chris", "Hello World!", "epicid"),
                new ModelChat("Chris", "How are you?", "epicid")
        );
        Log.i("Debug", "Entered getChats()");
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
