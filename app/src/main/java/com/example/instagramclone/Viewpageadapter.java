package com.example.instagramclone;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class Viewpageadapter extends FragmentPagerAdapter {

    private final List<Fragment> fragments=new ArrayList<>();
    private final List<String> fragmenttitles=new ArrayList<>();

    public Viewpageadapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragmenttitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmenttitles.get(position);
    }

    public void fragments(Fragment fragment,String title){
        fragments.add(fragment);
        fragmenttitles.add(title);
    }

}
