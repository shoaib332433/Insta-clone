package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Singup_Activity extends AppCompatActivity implements View.OnClickListener {

    EditText username,email,pass;
    Button signup,signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup_);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);

        signup=findViewById(R.id.signup);
        signup.setOnClickListener(Singup_Activity.this);


    }

    // Button click
    @Override
    public void onClick(View v) {

        final ParseUser user=new ParseUser();

        user.setEmail(email.getText().toString());
        user.setUsername(username.getText().toString());
        user.setPassword(pass.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e==null){
                    FancyToast.makeText(Singup_Activity.this,user.getUsername()+" Is Signup Sucessfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                }else{
                    FancyToast.makeText(Singup_Activity.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                }
            }
        });

    }
}
