package com.bw.movie.mvp.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.fragment.Bottomonefragment.Bottomone;
import com.bw.movie.fragment.Bottomonefragment.Bottomthree;
import com.bw.movie.fragment.Bottomonefragment.Bottomtwo;

import com.bw.movie.mvp.CustomViewPager;
import com.bw.movie.net.SpUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity {

    @BindView(R.id.Pager)
    CustomViewPager Pager;
    @BindView(R.id.but1)
    RadioButton but1;
    @BindView(R.id.but2)
    RadioButton but2;
    @BindView(R.id.but3)
    RadioButton but3;
    @BindView(R.id.Group)
    RadioGroup Group;
    private SpUtils spUtils;

    private String sessionId;
    private String userId;
    private ArrayList<Fragment> list;
    private CustomViewPager customViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
       Pager.setScanScroll(false);

       /* Object userId =(String) spUtils.getData("userId", null);

         Object sessionId =(String) spUtils.getData("sessionId", null);
        Toast.makeText(ShowActivity.this, this.userId + "", Toast.LENGTH_LONG).show();
        Toast.makeText(ShowActivity.this, this.sessionId + "", Toast.LENGTH_LONG).show();
*/
        list = new ArrayList<>();
        list.add(new Bottomone());
        list.add(new Bottomtwo());
        list.add(new Bottomthree());

        Pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        Pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i){
                    case 0:
                        Group.check(R.id.but1);
                        break;
                    case 1:
                        Group.check(R.id.but2);
                        break;
                    case 2:
                        Group.check(R.id.but3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.but1:
                        Pager.setCurrentItem(0);
                        break;
                    case R.id.but2:
                        Pager.setCurrentItem(1);
                        break;
                    case R.id.but3:
                        Pager.setCurrentItem(2);
                        break;

                }
            }
        });

    }
}
