package com.videodownloader.imagesfiles.socialmedia;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

    }

    @Override
    public void onBackPressed() {

        startActivity(new Intent(ActivityHelp.this, MainActivity.class));
        super.onBackPressed();
    }


}
