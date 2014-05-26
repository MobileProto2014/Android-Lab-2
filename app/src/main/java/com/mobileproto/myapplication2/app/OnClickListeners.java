package com.mobileproto.myapplication2.app;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

/**
 * Created by clee2 on 5/26/2014.
 */
public class OnClickListeners {
    public static View.OnClickListener helloWorldListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView text = (TextView) view; //Casting view to a TextView to access TextView methods
            Context context = view.getContext(); //Application Context for application resources
            text.setText(
                    text.getText().equals(context.getString(R.string.hello_world))? //If
                            context.getString(R.string.goodbye_world): //Then
                            context.getString(R.string.hello_world) //Else
            );
        }
    };
}
