package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
        signin=findViewById(R.id.signin);

        signup.setOnClickListener(Singup_Activity.this);
        signin.setOnClickListener(Singup_Activity.this);

        pass.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode==KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    onClick(signup);
                }
                return false;
            }
        });


    }

    // Button click
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.signup:
                final ParseUser user=new ParseUser();
                user.setEmail(email.getText().toString());
                user.setUsername(username.getText().toString());
                user.setPassword(pass.getText().toString());

                if (email.getText().toString().equals("") || username.getText().toString().equals("") || pass.getText().toString().equals("")){
                    FancyToast.makeText(Singup_Activity.this,"Email/Username/Password Is Required!",FancyToast.LENGTH_SHORT,FancyToast.INFO,false).show();
                }else{
                    final ProgressDialog dialog=new ProgressDialog(this);
                    dialog.setMessage( user.getUsername()+ " is Singing Up");
                    dialog.show();

                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e==null){
                                FancyToast.makeText(Singup_Activity.this,user.getUsername()+" Is Signup Sucessfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show();
                            }else{
                                FancyToast.makeText(Singup_Activity.this,e.getMessage(),FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                            }
                            dialog.dismiss();
                        }
                    });
                }
                break;

            case R.id.signin:
                Intent intent=new Intent(Singup_Activity.this,Singin_Activity.class);
                startActivity(intent);
                finish();
                break;
        }

    }



    public void inputmanager(View view){
        try {
            InputMethodManager inputMethodManager= (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
