package com.bw.movie.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bw.movie.R;
import com.bw.movie.fragment.Topfragment.TopOneFragment;
import com.bw.movie.fragment.Topfragment.TopThreeFragment;
import com.bw.movie.fragment.Topfragment.TopTwoFragment;
import com.bw.movie.fragment.myfragment.myonefragment;
import com.bw.movie.fragment.myfragment.mytwofragment;

import java.util.ArrayList;

public class MyMovieActivity extends AppCompatActivity {

    private RadioGroup reg1;
    private RadioButton r1;
    private RadioButton r2;
    private ViewPager vp2;
    private Button btn1;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movie);
        initView();
        getSupportActionBar().hide();
        list = new ArrayList<>();
        list.add(new myonefragment());
        list.add(new mytwofragment());
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyMovieActivity.this,ShowActivity.class));
            }
        });
        vp2.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });


        vp2.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        reg1.check(R.id.r1);
                        break;
                    case 1:
                        reg1.check(R.id.r2);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        reg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r1:
                        vp2.setCurrentItem(0);
                        break;
                    case R.id.r2:
                        vp2.setCurrentItem(1);
                        break;

                }
            }
        });

    }

    private void initView() {
        reg1 = (RadioGroup) findViewById(R.id.reg1);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        vp2 = (ViewPager) findViewById(R.id.vp2);
        btn1 = (Button) findViewById(R.id.btn1);
    }
}
