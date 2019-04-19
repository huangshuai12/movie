package com.bw.movie.mvp.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.entity.PingBean;
import com.bw.movie.entity.XiangBean;
import com.bw.movie.mvp.contract.PingContract;
import com.bw.movie.mvp.contract.XiangContract;
import com.bw.movie.mvp.myAdpater.popwindow.Deatails_Boss_Adapter;
import com.bw.movie.mvp.myAdpater.popwindow.PingAdapter;
import com.bw.movie.mvp.myAdpater.popwindow.PricterAdapter;
import com.bw.movie.mvp.myAdpater.popwindow.ShortVideoAdapter;
import com.bw.movie.mvp.presenter.PingPresenter;
import com.bw.movie.mvp.presenter.Xiangpresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.List;

import cn.jzvd.JZVideoPlayer;


public class XiangtActivity extends AppCompatActivity implements XiangContract.XxiangView, PingContract.PpingView {

    private String id;
    private Xiangpresenter xiangpresenter;
    private ImageView imageXi;
    private ImageView heart;
    private TextView nameXiang;
    private ImageView imageXiang;
    private ImageView buttonXiang;
    private Button buttonOneXiang;
    private Button buttonTwoYu;
    private Button buttonThreeJu;
    private Button buttonFourYing;
    private View mView;
    private PopupWindow mPopupWindow;
    private RecyclerView rev, revs;
    private XiangBean xiangBean;
    private Deatails_Boss_Adapter deatails_boss_adapter;
    private PricterAdapter pricterAdapter;
    private PingPresenter pingPresenter;
    private RecyclerView frag_recommend_4;
    private PingAdapter pingAdapter;
    private Button xiangOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangt);
        getSupportActionBar().hide();
        initView();

        final Intent intent = getIntent();
        id = intent.getStringExtra("id");
     /*   Toast.makeText(XiangtActivity.this,id+"",Toast.LENGTH_LONG).show();*/
        xiangpresenter = new Xiangpresenter(this);
        final HashMap<String, String> map = new HashMap<>();
        map.put("movieId", id + "");
        xiangpresenter.getXiang(null, null, map);

        buttonOneXiang.setOnClickListener(new popupwindowListener());
        buttonXiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(new Intent(XiangtActivity.this, Show2Activity.class));
                startActivity(intent1);
            }
        });

        buttonOneXiang.setOnClickListener(new popupwindowListener());
        buttonTwoYu.setOnClickListener(new popupwindowListenerss());
        buttonThreeJu.setOnClickListener(new popupwindowListeners());
        buttonFourYing.setOnClickListener(new popupwindowListener4());
        xiangOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(XiangtActivity.this, Xiang_MovieActivity.class);
                String s = nameXiang.getText().toString();
                intent1.putExtra("id", id + "");
             /*   Toast.makeText(XiangtActivity.this,id+"",Toast.LENGTH_LONG).show();*/
                intent1.putExtra("name", s);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void SuccessXiang(Object result) {
        xiangBean = (XiangBean) result;
        nameXiang.setText(xiangBean.getResult().getName());
        imageXiang.setImageURI(Uri.parse(xiangBean.getResult().getImageUrl()));

    }

    private void initView() {
        revs = (RecyclerView) findViewById(R.id.revs);
        imageXi = (ImageView) findViewById(R.id.image_xi);
        heart = (ImageView) findViewById(R.id.heart);
        nameXiang = (TextView) findViewById(R.id.name_xiang);
        imageXiang = (ImageView) findViewById(R.id.image_xiang);
        buttonXiang = (ImageView) findViewById(R.id.button_xiang);
        buttonOneXiang = (Button) findViewById(R.id.button_one_xiang);
        buttonTwoYu = (Button) findViewById(R.id.button_two_yu);
        buttonThreeJu = (Button) findViewById(R.id.button_three_ju);
        buttonFourYing = (Button) findViewById(R.id.button_four_ying);

        xiangOne = (Button) findViewById(R.id.xiang_one);
    }

    @Override
    public void SuccessPing(Object result) {
        PingBean pingBean = (PingBean) result;
        List<PingBean.ResultBean> result1 = pingBean.getResult();
        pingAdapter = new PingAdapter(this);
        frag_recommend_4.setAdapter(pingAdapter);
        pingAdapter.setList(result1);
    }

    //popwindow弹框
    public class popupwindowListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            showpopupwindow();
        }
    }

    public class popupwindowListener4 implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            showpopupwindow4();
        }
    }

    public class popupwindowListeners implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            showpopupwindows();
        }
    }

    public class popupwindowListenerss implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            showpopupwindowss();
        }
    }

    //详情
    private void showpopupwindow() {

        mView = LinearLayout.inflate(this, R.layout.pop_xiang, null);
        ImageView vies = mView.findViewById(R.id.pop_detail_finish);
        revs = mView.findViewById(R.id.revs);
        SimpleDraweeView pop_detail_img = mView.findViewById(R.id.img);
        TextView pop_detail_typetext = mView.findViewById(R.id.pop_detail_typetext);
        TextView pop_detail_director = mView.findViewById(R.id.pop_detail_director);
        TextView pop_detail_minute = mView.findViewById(R.id.pop_detail_minute);
        TextView pop_detail_place = mView.findViewById(R.id.pop_detail_place);
        TextView pop_detail_content = mView.findViewById(R.id.title);

        mPopupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, 1000, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        mPopupWindow.getContentView().setFocusableInTouchMode(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation(mView, Gravity.BOTTOM, 0, 0);

        pop_detail_img.setImageURI(Uri.parse(xiangBean.getResult().getImageUrl()));
        pop_detail_typetext.setText(getString(R.string.app_leixing) + xiangBean.getResult().getMovieTypes());
        pop_detail_minute.setText(getString(R.string.app_daoyan) + xiangBean.getResult().getDirector());
        pop_detail_place.setText(getString(R.string.app_shichang) + xiangBean.getResult().getDuration());
        pop_detail_director.setText(getString(R.string.app_chandi) + xiangBean.getResult().getPlaceOrigin());
        pop_detail_content.setText(xiangBean.getResult().getSummary());
        vies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(this);
        linearLayoutManagers.setOrientation(OrientationHelper.VERTICAL);
        revs.setLayoutManager(linearLayoutManagers);
        deatails_boss_adapter = new Deatails_Boss_Adapter(this, xiangBean.getResult());
        revs.setAdapter(deatails_boss_adapter);

    }

    //预告
    private void showpopupwindowss() {
     /*   Toast.makeText(XiangtActivity.this, "错误", Toast.LENGTH_LONG).show();*/
        mView = LinearLayout.inflate(this, R.layout.pop_film_short, null);
        ImageView vies = mView.findViewById(R.id.pop_detail_three);
        RecyclerView frag_recommend_3 = mView.findViewById(R.id.frag_recommend_2);
        mPopupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, 1000, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        mPopupWindow.getContentView().setFocusableInTouchMode(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation(mView, Gravity.BOTTOM, 0, 0);
        vies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
                JZVideoPlayer.releaseAllVideos();
            }
        });
        LinearLayoutManager linearLayoutManagers = new LinearLayoutManager(this);
        linearLayoutManagers.setOrientation(OrientationHelper.VERTICAL);
        frag_recommend_3.setLayoutManager(linearLayoutManagers);
        ShortVideoAdapter shortVideoAdapter = new ShortVideoAdapter(this, xiangBean.getResult());
        frag_recommend_3.setAdapter(shortVideoAdapter);
    }

    //剧照
    private void showpopupwindows() {
        mView = LinearLayout.inflate(this, R.layout.pop_film_stale, null);
        rev = mView.findViewById(R.id.rev);
        mView.findViewById(R.id.pop_detail_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
        mPopupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, 1000, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        mPopupWindow.getContentView().setFocusableInTouchMode(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation(mView, Gravity.BOTTOM, 0, 0);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rev.setLayoutManager(staggeredGridLayoutManager);
        pricterAdapter = new PricterAdapter(this, xiangBean.getResult());
        rev.setAdapter(pricterAdapter);
    }

    //评论
    private void showpopupwindow4() {
        mView = LinearLayout.inflate(this, R.layout.pop_film_ping, null);
        mView.findViewById(R.id.pop_detail_four).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.dismiss();
            }
        });
        frag_recommend_4 = mView.findViewById(R.id.frag_recommend_4);
        mPopupWindow = new PopupWindow(mView, LinearLayout.LayoutParams.MATCH_PARENT, 1000, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(this.getResources(), (Bitmap) null));
        mPopupWindow.setAnimationStyle(R.style.anim_menu_bottombar);
        mPopupWindow.getContentView().setFocusableInTouchMode(true);
        mPopupWindow.setFocusable(true);
        mPopupWindow.showAtLocation(mView, Gravity.BOTTOM, 0, 0);
        pingPresenter = new PingPresenter(this);

        frag_recommend_4.setLayoutManager(new LinearLayoutManager(this));
        HashMap<String, String> map = new HashMap<>();
        map.put("movieId", 1 + "");
        map.put("page", 1 + "");
        map.put("count", 5 + "");

        pingPresenter.getPing(map);

    }
}
