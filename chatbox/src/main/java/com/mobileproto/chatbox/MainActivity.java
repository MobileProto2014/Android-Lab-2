package com.mobileproto.chatbox;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mobileproto.chatbox.content.ContentManager;
import com.mobileproto.chatbox.fragments.ChatFragment;
import com.mobileproto.chatbox.fragments.HomeFragment;
import com.mobileproto.chatbox.listeners.OnClickListeners;

import java.util.HashMap;


public class MainActivity extends Activity {
    HashMap<String, ChatFragment> channelFragments = new HashMap<String, ChatFragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Sets this activity's content view to the activity_main.xml layout

        //Initialize content - channels/users/etc
        ContentManager.init();

        if (savedInstanceState == null) {
            //Setup colors
            ContentManager.addNewUser(ContentManager.username);
            if (ContentManager.username.equals("default")) {
                Toast.makeText(this, "You are signed in as default! Click the user icon to change your name!", Toast.LENGTH_SHORT).show();
            }
            //Setup Home Page
            initialUISetup();
        }
    }

    public void initialUISetup(){
        getFragmentManager().beginTransaction()
                            .add(R.id.fragment_container, new HomeFragment()).commit();
    }

    public void goToChannelFragment(String channelID){
        if (channelFragments.containsKey(channelID)){
            getFragmentManager().beginTransaction().add(channelFragments.get(channelID), channelID).commit();
        } else {
            ChatFragment newChannel = new ChatFragment();
            channelFragments.put(channelID, newChannel);
            getFragmentManager().beginTransaction().add(newChannel, channelID).commit();
        }
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
