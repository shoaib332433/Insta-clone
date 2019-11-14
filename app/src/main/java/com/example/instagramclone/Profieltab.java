package com.example.instagramclone;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.parse.ParseUser;

public class Profieltab extends Fragment implements View.OnClickListener{

    private Button logout,update;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_profieltab, container, false);

        logout=v.findViewById(R.id.logout);
        update=v.findViewById(R.id.update);

        update.setOnClickListener(this);
        logout.setOnClickListener(this);

        return v;
    }

    public void logoutuser(){
        Intent intent=new Intent(getContext(),Singin_Activity.class);
        startActivity(intent);
        getActivity().finish();
    }


    // onClick
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.logout:
                ParseUser.logOut();
                logoutuser();
                break;

            case R.id.update:
                Intent intent=new Intent(getContext(),Updateprofile.class);
                startActivity(intent);
                break;
        }


    }
}
