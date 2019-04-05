package com.jasjotsingh.androidsensorsintroduction;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private  static final String TAG = "MainActivity";

    ListView listView ;//lsitview in .xml
    SensorManager sensorManager ;//SensorManager is class
    List<Sensor> listsensor; //List of sensors
    List<String> liststring ;// list of strings
    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview1);

        liststring = new ArrayList<String>();

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        listsensor = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i=0; i<listsensor.size(); i++){

            liststring.add(listsensor.get(i).getName());
        }

        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_2,
                android.R.id.text1, liststring
        );

        // 1. Add click listener on Adapter items
        // 2. get value clicked postion from overridden method and then use that position to get Sensor object details from List<Sensor>
        // 3. Sensor object has been received. Now this data can be passed to a SensorDetailActivity via Intent.
        // 4. Use getIntent() method in SensorDetailActivity to receive the data.
        // 5. Set data received from getIntent to your textViews.

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Log.d(TAG, "onItemClick: "+ listsensor.get(arg2));

                Intent sensorIntent = new Intent(MainActivity.this, SensorDetailActivity.class);
                sensorIntent.putExtra("sensorName", listsensor.get(arg2).getName());
                sensorIntent.putExtra("sensorType", listsensor.get(arg2).getType());
                Log.d(TAG, "onItemClick: "+ listsensor.get(arg2).getType());
                sensorIntent.putExtra("vendor", listsensor.get(arg2).getVendor());
                sensorIntent.putExtra("version", listsensor.get(arg2).getVersion());
                Log.d(TAG, "onItemClickVersion: "+ listsensor.get(arg2).getVersion());
                sensorIntent.putExtra("maxrange", listsensor.get(arg2).getMaximumRange());
                sensorIntent.putExtra("resolution", listsensor.get(arg2).getResolution());
                sensorIntent.putExtra("mindelay", listsensor.get(arg2).getMinDelay());
                sensorIntent.putExtra("power", listsensor.get(arg2).getPower());
                startActivity(sensorIntent);

            }


        });

    }
}


