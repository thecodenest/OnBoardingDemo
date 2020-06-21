package com.rajendra.onboardingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.rajendra.onboardingdemo.adapter.IntroViewPagerAdapter;
import com.rajendra.onboardingdemo.model.Intro;

import java.util.ArrayList;
import java.util.List;

public class OnBoarding extends AppCompatActivity {

    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabLayout;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_on_boarding);

        final List<Intro> introList =new  ArrayList<>();

        introList.add(new Intro("Easy to post your job offer to job seekers","hey", R.drawable.oboarding1));
        introList.add(new Intro("Easy to post your job offer to job seekers","say", R.drawable.oboarding2));
        introList.add(new Intro("Easy to post your job offer to job seekers","day", R.drawable.oboarding3));


        final ViewPager viewPager = findViewById(R.id.screenPager);
        final Button next = findViewById(R.id.button);
        tabLayout = findViewById(R.id.tabIndicator);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, introList);
        viewPager.setAdapter(introViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        position = viewPager.getCurrentItem();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < introList.size()){
                    position++;
                    viewPager.setCurrentItem(position);
                }
                if(position == introList.size()){
                    savePrefData();
                    Toast.makeText(OnBoarding.this, "Hello", Toast.LENGTH_SHORT).show();
                    Toast.makeText(OnBoarding.this, ""+restorePref(), Toast.LENGTH_SHORT).show();
                }


            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                    position = tab.getPosition();
                 if(tab.getPosition() == introList.size() - 1){
                     next.setText("Get Started");
                 }
                 else{
                     next.setText("Next");

                 }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void savePrefData(){

        SharedPreferences sharedPreferences =   getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isFristTimeLaunch", true);
        editor.apply();

    }

    private boolean restorePref(){

        SharedPreferences sharedPreferences =   getApplicationContext().getSharedPreferences("mypref", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isFristTimeLaunch", false);
    }
}
