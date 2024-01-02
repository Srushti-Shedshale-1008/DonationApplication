package com.example.donation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        //hide action bar
        getSupportActionBar().hide();


        Thread background = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    //sleep for 3 sec
                    sleep(3 * 1000);

                    //start new activity
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);

                    //close current activity
                    MainActivity.this.finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        background.start();

    }
}
