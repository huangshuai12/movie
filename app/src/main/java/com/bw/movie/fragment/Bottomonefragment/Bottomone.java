package com.bw.movie.fragment.Bottomonefragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.MapView;
import com.bw.movie.R;
import com.bw.movie.entity.JiBean;
import com.bw.movie.entity.LunBean;
import com.bw.movie.entity.ZhengBean;
import com.bw.movie.mvp.contract.LunContract;

import com.bw.movie.mvp.myAdpater.ShouAdapter.JiAdapter;
import com.bw.movie.mvp.myAdpater.ShouAdapter.LunAdapter;
import com.bw.movie.mvp.myAdpater.ShouAdapter.RenAdapter;
import com.bw.movie.mvp.myAdpater.ShouAdapter.ZhegAdapter;
import com.bw.movie.mvp.presenter.Lunpresenter;
import com.bw.movie.mvp.view.Show2Activity;

import java.util.HashMap;
import java.util.List;

import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

public class Bottomone extends Fragment implements LunContract.LlunView ,View.OnClickListener,RenAdapter.SetOnClick,ZhegAdapter.SetOnClick1,JiAdapter.SetOnClick2 {
    private RecyclerCoverFlow mainCoverFlow;
    private Lunpresenter lunpresenter;
    private LunAdapter lunAdapter;
    private RecyclerView xrecRenmen;
    private RenAdapter renAdapter;
    private ZhegAdapter zhegAdapter;
    private RecyclerView xrecRenmen1;
    private RecyclerView xrecRenmen2;
    private JiAdapter jiAdapter;
    private ImageView search_image;
    private EditText search_edname;
    private TextView search_textName;
    private RelativeLayout search_linear;
    private AutoTransition transition;
    private MapView mMapView = null;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();

    private ImageView but11;
    private ImageView but22;
    private ImageView but33;
    private TextView index;
    private ImageView img;
    private TextView place;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_one, container, false);

        xrecRenmen = view.findViewById(R.id.xrec_renmen);
        xrecRenmen1 = view.findViewById(R.id.xrec_renmen1);
        xrecRenmen2 = view.findViewById(R.id.xrec_renmen2);
        mainCoverFlow = view.findViewById(R.id.main_CoverFlow);
        but11 = view.findViewById(R.id.but11);
        but22 = view. findViewById(R.id.but22);
        but33 = view.findViewById(R.id.but33);
        index=view.findViewById(R.id.index);
        place = view.findViewById(R.id.place);
        img = view.findViewById(R.id.img);
        img.setOnClickListener(new View.OnClickListener() {
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
        but11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Show2Activity.class));
            }
        });
        but22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Show2Activity.class));
            }
        });
        but33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),Show2Activity.class));
            }
        });

        search_linear = view.findViewById(R.id.search_linear);
        search_image = view.findViewById(R.id.search_image);
        search_edname = view.findViewById(R.id.search_edname);
        search_textName = view.findViewById(R.id.search_textName);
        search_image.setOnClickListener(this);
        search_textName.setOnClickListener(this);

        lunpresenter = new Lunpresenter(this);

        lunAdapter = new LunAdapter(getActivity());
        HashMap<String, String> map = new HashMap<>();
        map.put("page", 1 + "");
        map.put("count", 10 + "");
        lunpresenter.getLun(map);

     /*   mainCoverFlow.setFlatFlow(true);
        mainCoverFlow.setAdapter(new LunAdapter(getActivity()));
        mainCoverFlow.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
               index.setText((position+1)+"/"+mainCoverFlow.getLayoutManager().getItemCount());
            }
        });*/

        xrecRenmen.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("page", 1 + "");
        map1.put("count", 10 + "");
        lunpresenter.getRen(map1);

        xrecRenmen1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("page", 1 + "");
        map2.put("count", 10 + "");
        lunpresenter.getLZheng(map2);

        xrecRenmen2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("page", 1 + "");
        map3.put("count", 10 + "");
        lunpresenter.getJi(map3);
        return view;
    }

    @Override
    public void SuccessLun(Object result) {
        LunBean lunBean = (LunBean) result;
        List<LunBean.ResultBean> result1 = lunBean.getResult();
        lunAdapter.setList(result1);
        mainCoverFlow.setAdapter(lunAdapter);
    }

    @Override
    public void SuccessRen(Object result) {
        LunBean lunBean = (LunBean) result;
        List<LunBean.ResultBean> result1 = lunBean.getResult();
        renAdapter = new RenAdapter(getActivity());
        renAdapter.SetOnItemClick(this);
        renAdapter.setList(result1);
        xrecRenmen.setAdapter(renAdapter);
    }

    @Override
    public void SuccessZheng(Object result) {
        ZhengBean zhengBean = (ZhengBean) result;
        List<ZhengBean.ResultBean> result1 = zhengBean.getResult();
        zhegAdapter = new ZhegAdapter(getActivity());
        zhegAdapter.setList(result1);
        zhegAdapter.SetOnItemClick1(this);
        xrecRenmen1.setAdapter(zhegAdapter);


    }

    @Override
    public void SuccessJi(Object result) {
        JiBean jiBean = (JiBean) result;
        List<JiBean.ResultBean> result1 = jiBean.getResult();
        jiAdapter = new JiAdapter(getActivity());
        jiAdapter.setList(result1);
        jiAdapter.SetOnItemClick2(this);
        xrecRenmen2.setAdapter(jiAdapter);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_image:
                //点击搜索 伸展
                initExpand();
                break;
            case R.id.search_textName:
                //点击text收缩
                initReduce();
                break;
        }
    }


    /*设置伸展状态时的布局*/
    public void initExpand() {
        search_edname.setHint("CGV影城");
        search_edname.requestFocus();
        search_edname.setHintTextColor(Color.WHITE);
        search_textName.setText("搜索");
        search_textName.setVisibility(View.VISIBLE);
        search_edname.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams LayoutParams = (RelativeLayout.LayoutParams) search_linear.getLayoutParams();
        LayoutParams.width = dip2px(170);
        LayoutParams.setMargins(dip2px(0), dip2px(30), dip2px(0), dip2px(0));
        search_linear.setLayoutParams(LayoutParams);
        search_edname.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                search_edname.setFocusable(true);
                search_edname.setFocusableInTouchMode(true);
                return false;
            }
        });
        //开始动画
        beginDelayedTransition(search_linear);

    }

    /*设置收缩状态时的布局*/
    private void initReduce() {
        search_edname.setCursorVisible(false);
        search_edname.setVisibility(View.GONE);
        search_textName.setVisibility(View.GONE);
        RelativeLayout.LayoutParams LayoutParams = (RelativeLayout.LayoutParams) search_linear.getLayoutParams();
        LayoutParams.width = dip2px(40);
        LayoutParams.setMargins(dip2px(0), dip2px(40), dip2px(0), dip2px(0));
        search_linear.setLayoutParams(LayoutParams);

        //隐藏键盘
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
        search_edname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_edname.setCursorVisible(true);
            }
        });
        //开始动画
        beginDelayedTransition(search_linear);
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void beginDelayedTransition(ViewGroup view) {
        transition = new AutoTransition();
        transition.setDuration(500);
        TransitionManager.beginDelayedTransition(view, transition);
    }

    private int dip2px(float dpVale) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpVale * scale + 0.5f);
    }


    @Override
    public void SetClick(String cid) {
     /*   Toast.makeText(getActivity(),cid+"",Toast.LENGTH_LONG).show();*/
        Intent intent = new Intent(getActivity(), Show2Activity.class);
        intent.putExtra("id",cid);
        startActivity(intent);

    }

    @Override
    public void SetClick2(String cid) {
     /*   Toast.makeText(getActivity(),cid+"",Toast.LENGTH_LONG).show();*/
        Intent intent = new Intent(getActivity(), Show2Activity.class);
        intent.putExtra("id",cid);
        startActivity(intent);

    }

    @Override
    public void SetClick1(String cid) {
      /*  Toast.makeText(getActivity(),cid+"",Toast.LENGTH_LONG).show();*/
        Intent intent = new Intent(getActivity(), Show2Activity.class);
        intent.putExtra("id",cid);
        startActivity(intent);

    }
    public class MyLocationListener implements BDLocationListener {
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
            place.setText(locationDescribe + addr);

        }
    }
}
