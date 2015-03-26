package com.touchmenotapps.radialdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rikimarutsui on 3/26/15.
 */
public class LoginActivity extends Activity {
    private Button loginBtn; // Login Button
    private TextView userAccount /* User Account */ , passcode /* Passcode */ ;
    private DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    startActivity(new Intent(Intent.CATEGORY_HOME));
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    // do nothing
                    break;
            }
        }
    };


    @SuppressWarnings("serial")
    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.button_login);
        userAccount = (TextView) findViewById(R.id.text_login);
        passcode = (TextView) findViewById(R.id.text_passcode);

        loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
            public void onClick(View view){
                if(view == loginBtn){
                    Context context = getApplicationContext();
                    CharSequence text = "Login Successful!";
                    int duration = Toast.LENGTH_LONG;
                    final Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                            startActivity(new Intent(LoginActivity.this, ChestMenuActivity.class));
                        }
                    }, 1000);
                }
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            builder.setMessage("Are you sure leave the app?");
            builder.setPositiveButton("Yes", dialogClickListener);
            builder.setNegativeButton("No", dialogClickListener);
            builder.show();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
