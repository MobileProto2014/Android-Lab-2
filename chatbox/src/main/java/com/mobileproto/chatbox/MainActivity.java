package com.mobileproto.chatbox;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends FragmentActivity {
    //While Profile Pictures are not implemented
    public static HashMap<String, Integer> userColors = new HashMap<String, Integer>();
    public static List<Integer> colors = Arrays.asList(android.R.color.darker_gray,
            android.R.color.holo_blue_light,
            android.R.color.holo_green_light,
            android.R.color.holo_orange_light,
            android.R.color.holo_purple,
            android.R.color.holo_red_light,
            android.R.color.holo_blue_bright,
            android.R.color.holo_green_dark,
            android.R.color.holo_orange_dark,
            android.R.color.holo_red_dark,
            android.R.color.holo_blue_dark);

    //User Logistics
    public static String username = "default";
    public static String userId = "0001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Sets this activity's content view to the activity_main.xml layout
        //Setup colors
        addNewUser(MainActivity.username);
        if (MainActivity.username.equals("default")){
            Toast.makeText(this, "You are signed in as default! Click the user icon to change your name!", Toast.LENGTH_SHORT).show();
        }
    }


    public static void addNewUser(String username){
        userColors.put(username, colors.get(userColors.size() % colors.size()));
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
