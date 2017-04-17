package com.example.lineandcircle;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity  {

    RelativeLayout relativeLayout;
    LocationManager locationManager;
    TextView textView;
    Button line, circle;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        line = (Button) findViewById(R.id.line);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
//        circle= (Button) findViewById(R.id.circle);
        line.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (locationManager == null) {
                    Toast.makeText(getApplicationContext(), "no location", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    try {
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000*60*1,10,MainActivity.this);
                        Location location = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
                        boolean flag = locationManager.isProviderEnabled(LocationManager.PASSIVE_PROVIDER);
                        Toast.makeText(getApplicationContext(), flag + " ", Toast.LENGTH_LONG).show();
                        if (location != null) {
                            onLocationChanged(location);
                        } else
                            Toast.makeText(getApplicationContext(), "2 location is null", Toast.LENGTH_LONG).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),e+" ",Toast.LENGTH_LONG).show();
                    }
                    }
            }
        });
    }


    @Override
    public void onLocationChanged(Location location) {
        double latitude=location.getLatitude();
        double longitude=location.getLongitude();
        textView.setText("latitude is" + latitude + " longitude is " + longitude);

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderEnabled(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String s) {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }*/

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.textView);
        line= (Button) findViewById(R.id.line);
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeTOSDCard();
            }
        });
    }

    public void writeTOSDCard(){
        try {
            File file = new File("/sdcard/myfile.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.append(textView.getText().toString());
            outputStreamWriter.close();
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"done",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e+" ",Toast.LENGTH_LONG).show();
        }
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        line= (Button) findViewById(R.id.line);
        line.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setthealarm();
            }
        });
    }

    public void setthealarm(){
        Intent i=new Intent(MainActivity.this,handlerbroadcast.class);
        PendingIntent intent=PendingIntent.getBroadcast(getApplicationContext(),2,i,0);
        AlarmManager alarmManager= (AlarmManager) getSystemService(ALARM_SERVICE);
        Toast.makeText(getApplicationContext(),"alarm is set",Toast.LENGTH_LONG).show();
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+10000,intent);
    }
}
