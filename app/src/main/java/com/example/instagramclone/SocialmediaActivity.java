package com.example.instagramclone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

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
        adapter.fragments(new Userstab(),"Users");
        adapter.fragments(new Sharetab(),"Share");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
