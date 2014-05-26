package com.mobileproto.myapplication2.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Sets this activity's content view to the activity_main.xml layout

        setupViews(); //Sets up views in this content view.
    }

    private void setupViews(){
        TextView text = (TextView) findViewById(R.id.main_hello_text); //Find the TextView from the ContentView by ID.
        text.setOnClickListener(OnClickListeners.getHelloWorldListener(this)); //Set OnClick Listener for TextView click functionality
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
            case R.id.menu_settings:
                return true;

            case R.id.menu_blowUp:
                findViewById(R.id.main_boom_text).setVisibility(View.VISIBLE);
                ((TextView) findViewById(R.id.main_hello_text)).setText(getString(R.string.main_fix_text));

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
