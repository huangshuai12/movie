package com.bw.movie.fragment.Bottomonefragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.bw.movie.R;
import com.bw.movie.fragment.modelfragment.ModelOne;
import com.bw.movie.fragment.modelfragment.ModelTwo;
import com.bw.movie.net.SpUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Bottomtwo extends Fragment {


    @BindView(R.id.i)
    ImageView i;
    @BindView(R.id.but12)
    RadioButton but12;
    @BindView(R.id.but121)
    RadioButton but121;
    @BindView(R.id.Group12)
    RadioGroup Group12;
    @BindView(R.id.Pager12)
    ViewPager Pager12;
    Unbinder unbinder;
    @BindView(R.id.a)
    TextView a;
    private ArrayList<Fragment> list;
    private SpUtils spUtils;
    public LocationClient mLocationClient = null;
    private MyLocationListener1 myListener = new MyLocationListener1();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLocationClient = new LocationClient(getActivity().getApplicationContext());
                //声明LocationClient类
                mLocationClient.registerLocationListener(myListener);
                //注册监听函数
                LocationClientOption option = new LocationClientOption();
                option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
                //可选，是否需要位置描述信息，默认为不需要，即参数为false
                //如果开发者需要获得当前点的位置信息，此处必须为true
                option.setIsNeedLocationDescribe(true);
                //可选，设置是否需要地址信息，默认不需要
                option.setIsNeedAddress(true);
                //可选，默认false,设置是否使用gps
                option.setOpenGps(true);
                //可选，默认false，设置是否当GPS有效时按照1S/1次频率输出GPS结果
                option.setLocationNotify(true);
                mLocationClient.setLocOption(option);
                mLocationClient.start();
            }
        });
        list = new ArrayList<>();
        list.add(new ModelOne());
        list.add(new ModelTwo());

        Pager12.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        Pager12.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        Group12.check(R.id.but12);
                        break;
                    case 1:
                        Group12.check(R.id.but121);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        Group12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.but12:
                        Pager12.setCurrentItem(0);
                        break;
                    case R.id.but121:
                        Pager12.setCurrentItem(1);
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public class MyLocationListener1 implements BDLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //此处的BDLocation为定位结果信息类，通过它的各种get方法可获取定位相关的全部结果
            //以下只列举部分获取地址相关的结果信息
            //更多结果信息获取说明，请参照类参考中BDLocation类中的说明
            String locationDescribe = location.getLocationDescribe();    //获取位置描述信息
            String addr = location.getAddrStr();    //获取详细地址信息
            if (addr == null) {
                return;
            }
            spUtils.getInstance().saveData("longitude", null);
            spUtils.getInstance().saveData("latitude", null);
            a.setText(locationDescribe + addr);

        }
    }
}
