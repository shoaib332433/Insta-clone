package com.example.instagramclone;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class Updateprofile extends AppCompatActivity implements View.OnClickListener  {

    Button updateprofile;
    EditText name,nickname,aboutyourself,contactnum,address;
    ParseUser parseUser;

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

        parseUser=ParseUser.getCurrentUser();

        name.setText(parseUser.get("Name") + "");
        nickname.setText(parseUser.get("NickName")+"");
        aboutyourself.setText(parseUser.get("Aboutyourself")+"");
        contactnum.setText(parseUser.get("Contactnumber")+"");
        address.setText(parseUser.get("Address")+"");


    }

    //Onclick
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.updateprofile:


                parseUser.put("Name",name.getText().toString());
                parseUser.put("NickName",nickname.getText().toString());
                parseUser.put("Aboutyourself",aboutyourself.getText().toString());
                parseUser.put("Contactnumber",contactnum.getText().toString());
                parseUser.put("Address",address.getText().toString());


                final ProgressDialog progressDialog=new ProgressDialog(this);
                progressDialog.setMessage("Updating");
                progressDialog.show();

                parseUser.saveInBackground(new SaveCallback()
                 {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            FancyToast.makeText(Updateprofile.this,"Updated Sucessfully", Toast.LENGTH_SHORT,FancyToast.SUCCESS,false).show();
                        }else{
                            FancyToast.makeText(Updateprofile.this,e.getMessage(), Toast.LENGTH_SHORT,FancyToast.ERROR,false).show();
                        }
                        progressDialog.dismiss();
                    }
                });
                break;
        }
    }


}
