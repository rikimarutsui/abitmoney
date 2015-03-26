package com.touchmenotapps.radialdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rikimarutsui on 3/26/15.
 */
public class LoginActivity extends Activity {
    private Button loginBtn; // Login Button
    private TextView userAccount /* User Account */ , passcode /* Passcode */ ;

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
                            startActivity(new Intent(LoginActivity.this, MainMenu.class));
                        }
                    }, 1000);
                }
            }
        });

    }
}
