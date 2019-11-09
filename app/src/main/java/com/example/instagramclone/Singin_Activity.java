package com.example.instagramclone;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

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

        pass.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode==KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    onClick(signin);
                }
                return false;
            }
        });


    }

    // Button click
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.signin:


                if (username.getText().toString().equals("") || pass.getText().toString().equals("")){
                    FancyToast.makeText(Singin_Activity.this,"Username/Password Is Required!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                }else{
                    final ProgressDialog dialog=new ProgressDialog(this);
                    dialog.setMessage(username.getText().toString() +" is Singing In");
                    dialog.show();

                    ParseUser.logInInBackground(username.getText().toString(), pass.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user!=null && e==null){
                                FancyToast.makeText(Singin_Activity.this,user.get("username")+" Is Signin Sucessfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                                Intent intent=new Intent(Singin_Activity.this,SocialmediaActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                FancyToast.makeText(Singin_Activity.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                            }
                            dialog.dismiss();
                        }
                    });
                }
                break;

            case R.id.signup:
                Intent intent=new Intent(Singin_Activity.this,Singup_Activity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    public void onsideclick(View view){

        try {
            InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
