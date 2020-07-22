package com.example.musicbyjun.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.musicbyjun.Adapter.MainViewPagerAdapter;
import com.example.musicbyjun.Fragment.fragment_timkiem;
import com.example.musicbyjun.Fragment.fragment_trangchu;
import com.example.musicbyjun.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new fragment_trangchu(), "Home");
        mainViewPagerAdapter.addFragment(new fragment_timkiem(),"Search");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);

    }

    private void setControl() {
        tabLayout = findViewById(R.id.myTablayot);
        viewPager = findViewById(R.id.myViewPaper);

    }
}
