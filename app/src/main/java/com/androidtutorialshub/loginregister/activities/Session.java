package com.androidtutorialshub.loginregister.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUserEmail(String userEmail) {
        prefs.edit().putString("userEmail", userEmail).commit();
    }

    public String getuserEmail() {
        String userEmail = prefs.getString("userEmail","");
        return userEmail;
    }
    public void deleteEmail(){
        prefs.edit().clear();
        prefs.edit().commit();
    }
}