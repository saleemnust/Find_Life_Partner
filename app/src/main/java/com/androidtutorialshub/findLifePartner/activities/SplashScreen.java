package com.androidtutorialshub.findLifePartner.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.androidtutorialshub.findLifePartner.R;

public class SplashScreen extends Activity {
    protected boolean _active = true;
    protected int _splashTime = 1000; // time to display the splash screen in ms



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (_active && (waited < _splashTime)) {
                        sleep(100);
                        if (_active) {
                            waited += 100;
                        }
                    }
                } catch (Exception e) {

                } finally {

                    startActivity(new Intent(SplashScreen.this,
                            LoginActivity.class));
                    finish();
                }
            };
        };
        splashTread.start();
    }
}



/*public class SplashScreen extends Activity {
    private static boolean splashLoaded = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!splashLoaded) {
            setContentView(R.layout.splashscreen);
            int secondsDelayed = 1;
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }
            }, secondsDelayed * 3000);

            splashLoaded = true;
        }
        else {
            Intent goToMainActivity = new Intent(SplashScreen.this, LoginActivity.class);
            goToMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(goToMainActivity);
            finish();
        }
    }
}*/
