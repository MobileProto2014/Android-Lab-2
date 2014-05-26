package com.mobileproto.myapplication2.app;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by clee2 on 5/26/2014.
 */
public class OnClickListeners {
    /**
     * MainActivity OnClickListeners
     */
    public static View.OnClickListener getHelloWorldListener(final Activity activity) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView text = (TextView) view; //Casting view to a TextView to access TextView methods
                text.setText(
                        text.getText().equals(activity.getString(R.string.main_hello_world)) ? //If
                                activity.getString(R.string.main_goodbye_world) : //Then
                                activity.getString(R.string.main_hello_world) //Else
                );
                activity.findViewById(R.id.main_boom_text).setVisibility(View.INVISIBLE);
            }
        };
    }
}
