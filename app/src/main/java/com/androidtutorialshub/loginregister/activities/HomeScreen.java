package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

public class HomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
        //get all the variable values
        Button homeButton = (Button) findViewById(R.id.homeButton);
        Button profileButton = (Button) findViewById(R.id.profileButton);
        Button chatButton = (Button) findViewById(R.id.chatButton);
        Button menuButton = (Button) findViewById(R.id.menuButton);


        homeButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Session session = new Session(getApplicationContext()); //in oncreate
                        //session.deleteEmail();
                        Intent intent = new Intent(HomeScreen.this, HomeScreen.class);
                        startActivity(intent);
                    }
                }

        );
        profileButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Session session = new Session(getApplicationContext()); //in oncreate
                        Intent intent = new Intent(HomeScreen.this, ProfileActivity.class);
                        startActivity(intent);
                    }
                }

        );

       // DbHelper = new DatabaseHelper(this);

    }
}
