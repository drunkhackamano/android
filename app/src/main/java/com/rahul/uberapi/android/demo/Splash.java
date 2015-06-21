package com.rahul.uberapi.android.demo;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

/**
 *
 * @author mash
 *
 */
public class Splash extends Activity {

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    private final static String tag = Splash.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        Log.i(tag,"INICIA SPLASH");
        setContentView(R.layout.activity_splash);
        TimerTask task = new TimerTask(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(Splash.this, Menuapp.class);
                startActivity(mainIntent);
                finish();


                /*
                Uri webpage = Uri.parse("https://www.uber.com/log-in");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);

                */

                /*
                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
                */
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }




}
