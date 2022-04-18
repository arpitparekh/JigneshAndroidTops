package com.example.jigneshandroidtops.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityTabPagerBinding;
import com.google.android.material.tabs.TabLayout;

public class TabPagerActivity extends AppCompatActivity {


    private ActivityTabPagerBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTabPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Chat"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Video"));
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Status"));

        TabLayout.Tab tab1 = binding.tabLayout.getTabAt(0);
        tab1.setIcon(R.drawable.ic_menu);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(),getLifecycle());

        binding.viewPager.setAdapter(adapter);


        // change viewpager by selecting tab
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                binding.viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // change tab when viewpager is selected
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }
}