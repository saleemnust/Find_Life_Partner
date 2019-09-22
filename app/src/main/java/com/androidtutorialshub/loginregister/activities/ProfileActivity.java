package com.androidtutorialshub.loginregister.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;

import com.androidtutorialshub.loginregister.R;
import com.androidtutorialshub.loginregister.adapters.UsersRecyclerAdapter;
import com.androidtutorialshub.loginregister.model.User;
import com.androidtutorialshub.loginregister.sql.DatabaseHelper;


import java.util.ArrayList;
import java.util.List;

import com.androidtutorialshub.loginregister.R;


public class ProfileActivity extends AppCompatActivity {

    TextView name;
    ImageView editImage;
    DatabaseHelper DbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //get all the variable values
        name = (TextView) findViewById(R.id.name);
        editImage = (ImageView) findViewById(R.id.edit);

        editImage.setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ProfileActivity.this, EditProfile.class);
                        startActivity(intent);
                    }
                }

        );

        DbHelper = new DatabaseHelper(this);

        printDatabase2();


    }

    public void printDatabase() {
        //String email = "saleem1.ms1882@gmail.com";
        String email = "saleemseecs@gmail.com";
        //List<String> d = DbHelper.databaseToString(email);
        //String d = DbHelper.databaseToString(email);
        DatabaseHelper db = new DatabaseHelper(this);
        SQLiteDatabase df = db.getReadableDatabase();
        String query = "select * from user where user_email = " + email + ";";
        //String query = "select * from user where user_email = 'saleemseecs@gmail.com'";
        Cursor cursor = df.rawQuery(query, null);
        cursor.moveToFirst();
        //List<User> userList = DbHelper.getAllUser();
        name.setText(cursor.getString(cursor.getColumnIndex("user_email")));
/*        if(dbString) {
            name.setText(d);
        }
        else {
            name.setText("false");
        }*/
    }
public void printDatabase2(){
/*
        User user = new User();
        user.setId(1);
        user.setName("Muhammad Saleem");
        user.setEmail("saleemseecs@gmail.com");
        user.setPassword("m");
*/
    //db1.updateUser(user);



        DatabaseHelper db1 = new DatabaseHelper(this);
        String s = db1.printDatabase2("saleemseecs@gmail.com");

        /*SharedPreferences sp=getSharedPreferences("userName", Context.MODE_PRIVATE);
        String userName = sp.getString("userName", "ssss");
        name.setText(userName);*/

    Session session = new Session(getApplicationContext()); //in oncreate
    name.setText(session.getuserEmail());
    //session = new SessionManager(getApplicationContext());//<-- this is what you missed

}
}
