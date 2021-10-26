package com.mylocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;
import java.util.Locale;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    TextInputEditText etName,etMobile;
    MyPreference myPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
        myPreference=MyPreference.getInstance(this);
        etName=findViewById(R.id.et_name);
        etMobile=findViewById(R.id.et_mobile);
        findViewById(R.id.bt_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
        if (!TextUtils.isEmpty(myPreference.getMobile())){
            callIntent();
        }
    }

    private void validation() {
        String name=etName.getText().toString();
        String mobile=etMobile.getText().toString();
        if (TextUtils.isEmpty(name)){
            showToast("Enter name");
        }else if(TextUtils.isEmpty(mobile)){
            showToast("Enter Mobile");
        }else{

            myPreference.setName(name);
            myPreference.setMOBILE(mobile);
            callIntent();
        }
    }
    private void callIntent(){
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}