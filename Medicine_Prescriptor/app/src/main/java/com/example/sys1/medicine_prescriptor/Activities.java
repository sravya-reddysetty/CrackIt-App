package com.example.sys1.medicine_prescriptor;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Activities extends AppCompatActivity {
    private static final String TAG="Activities";
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        Log.d(TAG,"onCreate:Starting");
        mSectionsPageAdapter=new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }
    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter=new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new EditFragment(),"Edit");
        adapter.addFragment(new Details_Fragment(),"Details");
        adapter.addFragment(new Notification_Fragment(),"Notification");
        viewPager.setAdapter(adapter);

    }
}
