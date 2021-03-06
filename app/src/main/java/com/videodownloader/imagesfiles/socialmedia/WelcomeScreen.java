package com.videodownloader.imagesfiles.socialmedia;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class WelcomeScreen extends AppCompatActivity {
   ImageView splashLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        splashLayout=(ImageView)findViewById(R.id.splashimage);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.simpleanimation);
        splashLayout.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

//                Intent intent=new Intent(SplashActivity.this,WelcomeActivity.class);
//                startActivity(intent);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                },1000);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //5 seconds

    }
}