package com.jasjotsingh.androidsensorsintroduction;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SensorDetailActivity extends AppCompatActivity {
    private static final String TAG = "SensorDetailActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_detail);

        TextView tvSensorName = findViewById(R.id.SensorName);
        TextView tvVendor = findViewById(R.id.vendor);
        TextView tvVersion = findViewById(R.id.version);
        TextView tvType = findViewById(R.id.type);
        TextView tvMaxRange = findViewById(R.id.maxrange);
        TextView tvResolution = findViewById(R.id.resolution);
        TextView tvPower = findViewById(R.id.power);
        TextView tvMinDelay = findViewById(R.id.mindelay);

        Bundle sensorIntent2 = getIntent().getExtras();
        if (sensorIntent2 != null) {
            Log.d(TAG, "onCreate: "+sensorIntent2.getInt("sensorType"));
            Log.d(TAG, "onCreateVersion: "+ sensorIntent2.getString("version"));
            tvType.setText(" Type - "+sensorIntent2.get("sensorType")+"");
            tvVersion.setText(" Version - "+sensorIntent2.get("version")+"");
            tvMaxRange.setText(" Max Range - "+ sensorIntent2.get("maxrange")+"");
            tvResolution.setText(" Resolution - "+ sensorIntent2.get("resolution")+"");
            tvPower.setText(" Power - "+ sensorIntent2.get("power")+"");
            tvMinDelay.setText(" Min Delay - "+ sensorIntent2.get("mindelay")+"");
            tvSensorName.setText(" Sensor Name - "+sensorIntent2.getString("sensorName"));
            tvVendor.setText(" Vendor - "+sensorIntent2.get("vendor")+"");

        }




    }
}
