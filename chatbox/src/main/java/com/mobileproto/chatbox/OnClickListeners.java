package com.mobileproto.chatbox;

import android.view.View;
import android.widget.EditText;

/**
 * Created by clee2 on 5/26/2014.
 */
public class OnClickListeners {
    /**
     * MainActivity OnClickListeners
     */

    public static View.OnClickListener sendButtonListener(final EditText input, final AdapterChat adapter){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addChat(new ModelChat(MainActivity.username, input.getText().toString(), MainActivity.userId));
                input.clearComposingText();
            };
        };
    }
}
