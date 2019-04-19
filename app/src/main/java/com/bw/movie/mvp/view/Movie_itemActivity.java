package com.bw.movie.mvp.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.entity.MovieBean2;
import com.bw.movie.entity.MovieBean3;
import com.bw.movie.mvp.contract.MovieContract;
import com.bw.movie.mvp.myAdpater.MovieAdapterTwo;
import com.bw.movie.mvp.presenter.MoviePresenter;
import com.bw.movie.mvp.presenter.Xiangpresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Movie_itemActivity extends AppCompatActivity implements MovieContract.MmovieView,MovieAdapterTwo.SetOnClickTui{

    @BindView(R.id.name_id)
    TextView nameId;
    @BindView(R.id.name_zhi)
    TextView nameZhi;
    @BindView(R.id.img)
    SimpleDraweeView img;
    @BindView(R.id.pop_detail_typetext)
    TextView popDetailTypetext;
    @BindView(R.id.pop_detail_director)
    TextView popDetailDirector;
    @BindView(R.id.pop_detail_minute)
    TextView popDetailMinute;
    @BindView(R.id.pop_detail_place)
    TextView popDetailPlace;
    @BindView(R.id.rec_ok)
    RecyclerView recOk;
    private String id;
    private String name;
    private String title;
    private Xiangpresenter xiangpresenter;
    private MovieAdapterTwo movieAdapterTwo;
    private MoviePresenter moviePresenter;
    private String moived;
  /*  private ImageView buttonXiang22;*/
    private ImageView but11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_item);
        ButterKnife.bind(this);
        but11=findViewById(R.id.but11);
      /*  but11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Movie_itemActivity.this,XuanActivity.class));
            }
        });*/
       /* initView();*/
        getSupportActionBar().hide();
        final Intent intent = getIntent();
        id = intent.getStringExtra("id");
        moived = intent.getStringExtra("moived");
        name = intent.getStringExtra("name");
        title = intent.getStringExtra("title");
        nameId.setText(name);
        nameZhi.setText(title);
        moviePresenter = new MoviePresenter(this);
    /*    buttonXiang22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Movie_itemActivity.this, Xiang_MovieActivity.class);
                startActivity(intent1);
            }
        });*/

        HashMap<String, String> map = new HashMap<>();
        map.put("movieId", id + "");
        moviePresenter.getCity3(map);
        /*Toast.makeText(Movie_itemActivity.this,id+"",Toast.LENGTH_LONG).show();*/

        recOk.setLayoutManager(new LinearLayoutManager(this));
        movieAdapterTwo = new MovieAdapterTwo(this);
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("movieId", moived + "");
        map1.put("cinemasId", id + "");
        moviePresenter.getCity1(map1);

    }


    @Override
    public void SuccessCity(Object result) {

    }

    @Override
    public void SuccessCity1(Object result) {
        MovieBean2 movieBean2 = (MovieBean2) result;
        List<MovieBean2.ResultBean> result1 = movieBean2.getResult();
        recOk.setAdapter(movieAdapterTwo);
        movieAdapterTwo.SetMovieAdapterTwo(this);
        movieAdapterTwo.setList(result1);
    }

    @Override
    public void SuccessCity3(Object result) {
        MovieBean3 movieBean3 = (MovieBean3) result;
        img.setImageURI(Uri.parse(movieBean3.getResult().getImageUrl()));
        popDetailTypetext.setText(movieBean3.getResult().getName());
        popDetailMinute.setText(movieBean3.getResult().getDuration());
        popDetailPlace.setText(movieBean3.getResult().getPlaceOrigin() + "");
    }

    @Override
    public void ClickTui(String cid) {
        Intent intent = new Intent(Movie_itemActivity.this, XuanActivity.class);
        intent.putExtra("id",cid);
        startActivity(intent);
    }

   /* private void initView() {
        buttonXiang22 = (ImageView) findViewById(R.id.button_xiang22);
    }*/
}
