package com.mylocation;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class MyPreference {

    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;
    private static MyPreference myPreference;

    SharedPreferences sharedPreferences;
    public final static String PREFS_NAME = "appname_prefs";
    private MyPreference() {
    }
    public static String NAME="_name";
    public static String MOBILE="_mobile";

    public synchronized static MyPreference getInstance(Context context) {
        try {
            preferences = context.getSharedPreferences("insta_bill", Context.MODE_PRIVATE);
            editor = preferences.edit();
            if (myPreference == null)
                myPreference = new MyPreference();

        } catch (NullPointerException e) {
            Log.d("TAG", "getInstance: "+e.getMessage());

        }
        return myPreference;
    }
    public void setName(String name){
        editor.putString(NAME,name).apply();
    }
    public void setMOBILE(String mobile){
        editor.putString(MOBILE,mobile).apply();
    }
    public String getName(){
        return preferences.getString(NAME,"");
    }
    public String getMobile(){
        return preferences.getString(MOBILE,"");
    }



}
