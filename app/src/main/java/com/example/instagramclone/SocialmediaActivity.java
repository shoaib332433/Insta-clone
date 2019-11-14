package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SocialmediaActivity extends AppCompatActivity{

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socialmedia);

        tabLayout=findViewById(R.id.tablayout);
        appBarLayout=findViewById(R.id.tablayoutbar);
        viewPager=findViewById(R.id.viewpager);

        Viewpageadapter adapter=new Viewpageadapter(getSupportFragmentManager());
        adapter.fragments(new Profieltab(),"Profile");
        adapter.fragments(new Sharetab(),"Share");
        adapter.fragments(new Userstab(),"Users");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }


}
