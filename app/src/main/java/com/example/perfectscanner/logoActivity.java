package com.example.perfectscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import static android.os.SystemClock.sleep;

public class logoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.white));
        }
        Thread thread= new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(1500);
                Intent i = new Intent(logoActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        thread.start();
    }
}