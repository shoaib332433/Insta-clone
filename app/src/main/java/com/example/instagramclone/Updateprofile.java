package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Updateprofile extends AppCompatActivity implements View.OnClickListener  {

    Button updateprofile;
    EditText name,nickname,aboutyourself,contactnum,address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateprofile);


        updateprofile=findViewById(R.id.updateprofile);
        name=findViewById(R.id.name);
        nickname=findViewById(R.id.nickname);
        aboutyourself=findViewById(R.id.aboutyou);
        contactnum=findViewById(R.id.contactnumber);
        address=findViewById(R.id.address);





        updateprofile.setOnClickListener(this);

    }


    //Onclick
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.updateprofile:


                ParseUser parseUser=ParseUser.getCurrentUser();

                parseUser.put("Name",name.getText().toString());
                parseUser.put("Nick Name",nickname.getText().toString());
                parseUser.put("About your self",aboutyourself.getText().toString());
                parseUser.put("Contact number",contactnum.getText().toString());
                parseUser.put("Address",address.getText().toString());


                parseUser.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            FancyToast.makeText(Updateprofile.this,"Updated Sucessfully", Toast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                        }else{
                            FancyToast.makeText(Updateprofile.this,e.getMessage(), Toast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                        }
                    }
                });

                break;
        }
    }


}
