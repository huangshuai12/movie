package com.bw.movie.mvp.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.entity.CityBean;
import com.bw.movie.entity.CityChengBean;
import com.bw.movie.entity.CityLunBean;
import com.bw.movie.entity.CityZhanBean;
import com.bw.movie.mvp.contract.CityChenContract;
import com.bw.movie.mvp.contract.CityContract;
import com.bw.movie.mvp.myAdpater.DateAdapter;
import com.bw.movie.mvp.myAdpater.MovieLunAdapter;
import com.bw.movie.mvp.presenter.Citypresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class MovieActivity extends AppCompatActivity implements CityContract.CityView, CityChenContract.CityChenView {

    private Citypresenter citypresenter;
    private SimpleDraweeView movieItemOneImage;
    private TextView movieItemOneTitle;
    private TextView movieItemOneName;
    private RecyclerCoverFlow flow;
    private MovieLunAdapter movieLunAdapter;
    private RecyclerView moveThree;
    private CityZhanBean cityZhanBean;
    private DateAdapter dateAdapter;
    private String id;
    private PopupWindow mPopupWindow;
    private RecyclerCoverFlow mainCoverFlow1;
    private View mView;
    private CityChengBean cityChengBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        getSupportActionBar().hide();
        initView();
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        citypresenter = new Citypresenter(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("cinemaId", id + "");
        citypresenter.getCity(map);

        movieLunAdapter = new MovieLunAdapter(this);
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("cinemaId", id + "");
        citypresenter.getCity1(map1);

        dateAdapter = new DateAdapter(this);
        moveThree.setLayoutManager(new LinearLayoutManager(this));
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("cinemasId", id + "");
        map2.put("movieId", id + "");
        citypresenter.getCity2(map2);

        movieItemOneName.setOnClickListener(new popupwindowListeners());
    }

    private void initView() {
        movieItemOneImage = (SimpleDraweeView) findViewById(R.id.movie_item_one_image);
        movieItemOneTitle = (TextView) findViewById(R.id.movie_item_one_title);
        movieItemOneName = (TextView) findViewById(R.id.movie_item_one_name);
        flow = (RecyclerCoverFlow) findViewById(R.id.main_CoverFlow1);
        moveThree = (RecyclerView) findViewById(R.id.move_three);
        mainCoverFlow1 = (RecyclerCoverFlow) findViewById(R.id.main_CoverFlow1);
    }

    @Override
    public void SuccessCity(Object result) {
        CityBean cityBean = (CityBean) result;
        movieItemOneImage.setImageURI(Uri.parse(cityBean.getResult().getLogo()));
        movieItemOneName.setText(cityBean.getResult().getName());
        movieItemOneTitle.setText(cityBean.getResult().getAddress());
    }

    @Override
    public void SuccessCity1(Object result) {
        CityLunBean cityLunBean = (CityLunBean) result;
        if (cityLunBean.getResult() == null) {
            return;
        } else {
            final List<CityLunBean.ResultBean> result1 = cityLunBean.getResult();
            movieLunAdapter.setList(result1);
            flow.setAdapter(movieLunAdapter);
        }
    }

    @Override
    public void SuccessCity2(final Object result) {
        flow.setVisibility(View.VISIBLE);
        cityZhanBean = (CityZhanBean) result;
        final List<CityZhanBean.ResultBean> result1 = cityZhanBean.getResult();
        moveThree.setAdapter(dateAdapter);
        dateAdapter.setList(result1);
    }

    @Override
    public void SuccessCityChen(Object result) {
        cityChengBean = (CityChengBean) result;

    }

    public class popupwindowListeners implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            showpopupwindows();
        }
    }


    private void showpopupwindows() {

        mView = LinearLayout.inflate(this, R.layout.pop_pop_xiang, null);
        mPopupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, 1000, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        mPopupWindow.getContentView().setFocusableInTouchMode(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation(mView, Gravity.BOTTOM, 0, 0);



    }

}
