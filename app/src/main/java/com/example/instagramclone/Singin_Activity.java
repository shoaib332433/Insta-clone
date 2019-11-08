package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Singin_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText username,pass;
    Button signup,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_);
        ParseInstallation.getCurrentInstallation().saveInBackground();


        username=findViewById(R.id.username);
        pass=findViewById(R.id.password);

        signup=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);

        signup.setOnClickListener(Singin_Activity.this);
        signin.setOnClickListener(Singin_Activity.this);


    }

    // Button click
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.signin:
                ParseUser.logInInBackground(username.getText().toString(), pass.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user!=null && e==null){
                            FancyToast.makeText(Singin_Activity.this,user.get("username")+" Is Signin Sucessfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                        }else{
                            FancyToast.makeText(Singin_Activity.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                        }
                    }
                });

                break;

            case R.id.signup:
                Intent intent=new Intent(Singin_Activity.this,Singup_Activity.class);
                startActivity(intent);
                finish();
                break;
        }



    }
}
