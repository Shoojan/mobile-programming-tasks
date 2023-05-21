package com.example.gridviewdemo.tasks.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.example.gridviewdemo.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class NewsPortalDesign extends AppCompatActivity implements HeadlineFragment.SendMessage {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    TabPagerAdapter tabPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_portal_design);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("KBC News");
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager);
        tabPagerAdapter = new TabPagerAdapter(this);
        tabPagerAdapter.addFragment(new HeadlineFragment(), "Headlines");
        tabPagerAdapter.addFragment(new NewsDetailFragment(), "Details");

        viewPager.setAdapter(tabPagerAdapter);
        viewPager.setCurrentItem(0);

        tabLayout = findViewById(R.id.tabs);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(tabPagerAdapter.getTabTitle(position))
        ).attach();
    }

    @Override
    public void sendData(String message) {
        viewPager.setCurrentItem(1);

        NewsDetailFragment newsDetailFragment = (NewsDetailFragment) tabPagerAdapter.getFragmentByTitle("Details");
        if (newsDetailFragment != null) {
            newsDetailFragment.displayReceivedData(message);
        }

    }

}