package com.rahul.uberapi.android.demo;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class Game extends Activity implements SensorEventListener{
    /** Called when the activity is first created. */
    TextView x,y,z,label;
    private  Sensor mAccelerometer;
    private int counter=0;
    Button btn_regresar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getActionBar().hide();
        x = (TextView)findViewById(R.id.xID);
        y = (TextView)findViewById(R.id.yID);
        z = (TextView)findViewById(R.id.zID);
        label = (TextView)findViewById(R.id.label);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        btn_regresar = (Button) findViewById(R.id.btn_regresar);
        //Log.i(TAG, "PANTALLA DE HOME");
        btn_regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mIntent = new Intent(Game.this, Menuapp.class);
                startActivity(mIntent);

                finish();
            }
        });


    }




    protected void onResume()
    {
        super.onResume();
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (sensors.size() > 0) //dispositivo android tiene acelerometro
        {
            sm.registerListener(this, sensors.get(0), SensorManager.SENSOR_DELAY_GAME);
        }
    }
    protected void onPause()
    {
        SensorManager mSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorManager.unregisterListener(this, mAccelerometer);
        super.onPause();
    }
    protected void onStop()
    {
        SensorManager mSensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorManager.unregisterListener(this, mAccelerometer);
        super.onStop();
    }


    @Override
    public void onSensorChanged(SensorEvent event) {


        this.x.setText("X = " + event.values[SensorManager.DATA_X]);
        this.y.setText("Y = " + event.values[SensorManager.DATA_Y]);
        this.z.setText("Z = " + event.values[SensorManager.DATA_Z]);
        //getResources().getColor(R.color.red);





        /*
        if(counter > 100 && counter < 102){

            Context context = getApplicationContext();
            CharSequence text = "Borracho!";
            int duration = Toast.LENGTH_SHORT;

            //Toast toast = Toast.makeText(context, text, duration);
            //toast.show();

            Intent UberIntent = new Intent(Game.this, Uber.class);
            startActivity(UberIntent);
            this.finish();



            //Uri webpage = Uri.parse("https://www.uber.com/log-in");
            //Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            //startActivity(webIntent);
            //finish();


        }else {

        */

            if (event.values[SensorManager.DATA_Y] > 0) {
                if (event.values[SensorManager.DATA_Y] > 7) {
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.main);
                    rl.setBackgroundColor(getResources().getColor(R.color.red));
                    //counter = counter    + 1 ;

                    this.label.setText(" Estas Borracho");



                /*
                Uri webpage = Uri.parse("https://www.uber.com/log-in");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
                finish();
                */

                } else if (event.values[SensorManager.DATA_Y] > 4 && event.values[SensorManager.DATA_Y] < 7) {
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.main);
                    rl.setBackgroundColor(getResources().getColor(R.color.naranja));

                    this.label.setText("Haz un 4");

                } else if (event.values[SensorManager.DATA_Y] > 2 && event.values[SensorManager.DATA_Y] < 4) {
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.main);
                    rl.setBackgroundColor(getResources().getColor(R.color.amarillo));
                    this.label.setText("Haz un 4");

                } else if (event.values[SensorManager.DATA_Y] < 2) {
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.main);
                    rl.setBackgroundColor(getResources().getColor(R.color.verde));
                    this.label.setText("Haz un 4");
                }
            } else if (event.values[SensorManager.DATA_Y] < 0) {
                if (event.values[SensorManager.DATA_Y] < -7) {
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.main);
                    rl.setBackgroundColor(getResources().getColor(R.color.red));

                    //counter = counter    + 1 ;
                    this.label.setText(" Estas Borracho");

                /*
                Uri webpage = Uri.parse("https://www.uber.com/log-in");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
                finish();

                */

                } else if (event.values[SensorManager.DATA_Y] < -4 && event.values[SensorManager.DATA_Y] > -7) {
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.main);
                    rl.setBackgroundColor(getResources().getColor(R.color.naranja));
                    this.label.setText("Haz un 4");
                } else if (event.values[SensorManager.DATA_Y] < -2 && event.values[SensorManager.DATA_Y] > -4) {
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.main);
                    rl.setBackgroundColor(getResources().getColor(R.color.amarillo));
                    this.label.setText("Haz un 4");
                } else if (event.values[SensorManager.DATA_Y] > -2) {
                    RelativeLayout rl = (RelativeLayout) findViewById(R.id.main);
                    rl.setBackgroundColor(getResources().getColor(R.color.verde));
                    this.label.setText("Haz un 4");
                }


            }
        //}


    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}

/*
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Game extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

*/
