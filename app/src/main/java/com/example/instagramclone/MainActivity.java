package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.parse.ParseUser;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (ParseUser.getCurrentUser() != null){
                        gettosocialmediaactivity();
                    }else{
                        Intent intent=new Intent(MainActivity.this,Singup_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            },2000);



    }

    private void gettosocialmediaactivity(){
        Intent intent=new Intent(MainActivity.this,SocialmediaActivity.class);
        startActivity(intent);
        finish();
    }

}
