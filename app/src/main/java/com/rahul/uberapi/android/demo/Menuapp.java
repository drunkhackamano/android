package com.rahul.uberapi.android.demo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Menuapp extends ActionBarActivity {
    Button btn_motriz;
    Button btn_visual;
    Button btn_uber;


    public void startNewActivity(Context context, String packageName) {
        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
        if (intent != null) {
        /* We found the activity now start the activity */
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        } else {
        /* Bring user to the market or let them choose an app? */
            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + packageName));
            context.startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuapp);




        btn_motriz = (Button) findViewById(R.id.btn_motriz);
        //Log.i(TAG, "PANTALLA DE HOME");
        btn_motriz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(Menuapp.this, Game.class);
                startActivity(mIntent);

                finish();
            }
        });

        btn_visual = (Button) findViewById(R.id.btn_visual);
        //Log.i(TAG, "PANTALLA DE HOME");
        btn_visual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startNewActivity(Menuapp.this, "mx.mash.lustrador");
                startNewActivity(Menuapp.this, "appinventor.ai_ivandeleon.Drunk");

                /*
                Intent mIntent = new Intent(Menuapp.this, Game.class);
                startActivity(mIntent);
                finish();
                */

            }
        });



        btn_uber = (Button) findViewById(R.id.btn_uber);
        //Log.i(TAG, "PANTALLA DE HOME");
        btn_uber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startNewActivity(Menuapp.this, "com.ubercab");
                /*
                Uri webpage = Uri.parse("https://www.uber.com/log-in");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
                finish();

                */
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menuapp, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
