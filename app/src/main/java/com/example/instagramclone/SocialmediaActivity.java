package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SocialmediaActivity extends AppCompatActivity implements View.OnClickListener {

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialmedia);

        logout=findViewById(R.id.logout);

        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ParseUser.logOut();
        Intent intent=new Intent(SocialmediaActivity.this,Singin_Activity.class);
        startActivity(intent);
        finish();
    }
}
