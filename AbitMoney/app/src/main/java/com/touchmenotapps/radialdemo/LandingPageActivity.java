package com.touchmenotapps.radialdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by rikimarutsui on 3/26/15.
 */
public class LandingPageActivity extends Activity{

    private ProgressBar progressBar;

    @Override
    public void onCreate(Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.activity_landing);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LandingPageActivity.this, MainMenu.class));
            }
        }, 1000);
    }

}
