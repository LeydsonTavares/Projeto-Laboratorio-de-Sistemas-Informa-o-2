package com.example.leydsontavares.beerregisterapplication.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.leydsontavares.beerregisterapplication.R;

public class SplashScreenActivity extends Activity implements Runnable {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final ImageView animationImageView = (ImageView) findViewById(R.id.AnimationImageView);
        animationImageView.setBackgroundResource(R.drawable.ic_splash);
        final AnimationDrawable frameAnimation = (AnimationDrawable) animationImageView.getBackground();
        animationImageView.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });
        Handler h = new Handler();
        h.postDelayed(this, 2000);
    }

    @Override
    public void run() {
        startActivity(new Intent(this,ListarBeerActivity.class));
        finish();

    }
}

