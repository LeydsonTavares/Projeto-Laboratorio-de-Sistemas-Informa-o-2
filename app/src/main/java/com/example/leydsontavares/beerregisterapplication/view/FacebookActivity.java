package com.example.leydsontavares.beerregisterapplication.view;



import android.app.Activity;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.example.leydsontavares.beerregisterapplication.R;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.OnClick;


public class FacebookActivity extends Activity {


    @Bind(R.id.login_button)
    LoginButton mLoginButton;

    private static final String APP_ID = "1770677599847360";
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_postar_facebook);

        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                AccessToken accessToken = loginResult.getAccessToken();

                Toast.makeText(FacebookActivity.this, "Facebook login was successful", Toast.LENGTH_SHORT).show();

                String authToken = accessToken.getToken();
                // User authToken here:
            }

            @Override
            public void onCancel() {
                Toast.makeText(FacebookActivity.this,  "Facebook login was canceled", Toast.LENGTH_SHORT).show();

                LoginManager.getInstance().logOut();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(FacebookActivity.this,  "Facebook login failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    @OnClick(R.id.login_button)
    public void onClick(View v) {
        LoginManager.getInstance().logInWithReadPermissions(FacebookActivity.this, Arrays.asList("public_profile"));

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}








