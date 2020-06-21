package com.rajendra.onboardingdemo.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.rajendra.onboardingdemo.R;
import com.rajendra.onboardingdemo.model.Intro;

import java.util.List;

public class IntroViewPagerAdapter extends PagerAdapter {

    Context context;
    List<Intro> introList;

    public IntroViewPagerAdapter(Context context, List<Intro> introList) {
        this.context = context;
        this.introList = introList;
    }

    @Override
    public int getCount() {
        return introList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.intro_screen_layout, null);

        ImageView image = view.findViewById(R.id.imageView);
        TextView title = view.findViewById(R.id.title);
        TextView desc = view.findViewById(R.id.desc);


        image.setImageResource(introList.get(position).getImageUrl());
        title.setText(introList.get(position).getTitle());
        desc.setText(introList.get(position).getDesc());
        container.addView(view);
        return view;
    }
}
