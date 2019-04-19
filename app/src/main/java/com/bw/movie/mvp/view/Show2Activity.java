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
import com.bw.movie.fragment.Bottomonefragment.Bottomone;
import com.bw.movie.fragment.Bottomonefragment.Bottomthree;
import com.bw.movie.fragment.Bottomonefragment.Bottomtwo;
import com.bw.movie.fragment.Topfragment.TopOneFragment;
import com.bw.movie.fragment.Topfragment.TopThreeFragment;
import com.bw.movie.fragment.Topfragment.TopTwoFragment;

import java.util.ArrayList;

public class Show2Activity extends AppCompatActivity {

    private RadioGroup rg;
    private RadioButton rg1;
    private RadioButton rg2;
    private RadioButton rg3;
    private ViewPager vp;
    private Button btn;
    private ArrayList<Fragment> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show2);
        getSupportActionBar().hide();
        initView();
        list = new ArrayList<>();
        list.add(new TopOneFragment());
        list.add(new TopTwoFragment());
        list.add(new TopThreeFragment());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Show2Activity.this,ShowActivity.class));
            }
        });
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });


        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        rg.check(R.id.rg1);
                        break;
                    case 1:
                        rg.check(R.id.rg2);
                        break;
                    case 2:
                        rg.check(R.id.rg3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rg1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rg2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rg3:
                        vp.setCurrentItem(2);
                        break;

                }
            }
        });

    }

    private void initView() {
        rg = (RadioGroup) findViewById(R.id.rg);
        rg1 = (RadioButton) findViewById(R.id.rg1);
        rg2 = (RadioButton) findViewById(R.id.rg2);
        rg3 = (RadioButton) findViewById(R.id.rg3);
        vp = (ViewPager) findViewById(R.id.vp);
        btn = (Button) findViewById(R.id.btn);
    }
}
