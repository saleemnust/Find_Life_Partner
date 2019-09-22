package com.androidtutorialshub.loginregister.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;

public class EditProfile extends AppCompatActivity {
    TextView name;
    ImageView editImage;
    DatabaseHelper DbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);
        //get all the variable values
        name = (TextView) findViewById(R.id.name);
        editImage = (ImageView) findViewById(R.id.edit);

        editImage.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(EditProfile.this, ProfileActivity.class);
                        startActivity(intent);

                    }
                }

        );

        DbHelper = new DatabaseHelper(this);


    }

}
