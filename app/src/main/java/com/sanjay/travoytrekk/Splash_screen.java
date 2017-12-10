package com.sanjay.travoytrekk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.sanjay.travoytrekk.util.ApplicationUtility;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_screen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Timer t = new Timer();
        boolean checkConnection=new ApplicationUtility().checkConnection(this);
        if (checkConnection) {
            t.schedule(new splash(), 3000);
        } else {
            Toast.makeText(Splash_screen.this,
                    "connection not found...plz check connection", Toast.LENGTH_LONG).show();
        }
    }

    class splash extends TimerTask {

        @Override
        public void run() {
            Intent i = new Intent(Splash_screen.this,Dashboard.class);
            finish();
            startActivity(i);
        }


    }
}
