package com.mobileproto.chatbox;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by clee2 on 5/26/2014.
 */
public class OnClickListeners {
    /**
     * MainActivity OnClickListeners
     */

    public static View.OnClickListener sendButtonListener(final Activity activity, final AdapterChat adapter){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = ((EditText) activity.findViewById(R.id.main_chat_input));
                Log.i("DebugDebug", input.getText().toString());
                adapter.addChat(new ModelChat(MainActivity.username, input.getText().toString(), MainActivity.userId));
                input.setText("");
            };
        };
    }
}
