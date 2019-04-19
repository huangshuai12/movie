package com.bw.movie.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bw.movie.R;
import com.bw.movie.fragment.qiefragment.yinfourActivity;
import com.bw.movie.fragment.qiefragment.yinoneActivity;
import com.bw.movie.fragment.qiefragment.yinthreeActivity;
import com.bw.movie.fragment.qiefragment.yintwoActivity;
import com.bw.movie.mvp.view.LoginActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QieActivity extends AppCompatActivity {

    @BindView(R.id.pager)
    ViewPager pager;


    private SharedPreferences.Editor editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qie);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        final ArrayList<Fragment> list= new ArrayList<>();
        list.add(new yinoneActivity());
        list.add(new yintwoActivity());
        list.add(new yinthreeActivity());
        list.add(new yinfourActivity());

        SharedPreferences sharedPreferences = getSharedPreferences("djs",Context.MODE_PRIVATE);
        editText = sharedPreferences.edit();
        if (sharedPreferences.getBoolean("第一次",false)){
            Intent intent = new Intent(QieActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();

        }

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //用监听监听线程，让滑动到地4个页面后1秒跳转
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(final int i) {
              /*  currentItem = position;//获取位置，即第几页*/

             /*   Log.i("Guide","监听改变"+i);*/

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (i==3){
                            editText.putBoolean("第一次",true).commit();
                            Intent intent = new Intent(QieActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                },1000);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }
}
