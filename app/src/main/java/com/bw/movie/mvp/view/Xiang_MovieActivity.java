package com.bw.movie.mvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.entity.MovieBean1;
import com.bw.movie.mvp.contract.MovieContract;
import com.bw.movie.mvp.myAdpater.MovieAdapter;
import com.bw.movie.mvp.presenter.MoviePresenter;

import java.util.HashMap;
import java.util.List;

public class Xiang_MovieActivity extends AppCompatActivity implements MovieContract.MmovieView, MovieAdapter.SetOnClickTui {

    private TextView text2;
    private String name;
    private String id;
    private RecyclerView recycleCommentOne;
    private MoviePresenter moviePresenter;
    private MovieAdapter movieAdapter;
    private ImageView buttonXiang12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang__movie);
        getSupportActionBar().hide();
        initView();
        final Intent intent = getIntent();
        name = intent.getStringExtra("name");
        id = intent.getStringExtra("id");
     /*   buttonXiang12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Xiang_MovieActivity.this, XiangtActivity.class);
                startActivity(intent1);
            }
        });
*/
     /*   Toast.makeText(Xiang_MovieActivity.this, id + "", Toast.LENGTH_LONG).show();*/
        text2.setText(name);
        moviePresenter = new MoviePresenter(this);
        recycleCommentOne.setLayoutManager(new LinearLayoutManager(Xiang_MovieActivity.this));
        final HashMap<String, String> map = new HashMap<>();
        map.put("movieId", id + "");
        moviePresenter.getCity(map);

    }

    private void initView() {
        text2 = (TextView) findViewById(R.id.text2);
        recycleCommentOne = (RecyclerView) findViewById(R.id.recycle_comment_one);
    /*    buttonXiang12 = (ImageView) findViewById(R.id.button_xiang12);*/
    }

    @Override
    public void SuccessCity(Object result) {
        MovieBean1 movieBean1 = (MovieBean1) result;
        List<MovieBean1.ResultBean> result1 = movieBean1.getResult();
        movieAdapter = new MovieAdapter(this);
        movieAdapter.SetOnItemClickTui(this);
        recycleCommentOne.setAdapter(movieAdapter);
        movieAdapter.setList(result1);
    }

    @Override
    public void SuccessCity1(Object result) {

    }

    @Override
    public void SuccessCity3(Object result) {

    }


    @Override
    public void ClickTui(String moived, String name, String title) {
        Intent intent = new Intent(Xiang_MovieActivity.this, Movie_itemActivity.class);
        intent.putExtra("moived", moived);
        intent.putExtra("id", id);
        /*Toast.makeText(Xiang_MovieActivity.this, id + "", Toast.LENGTH_LONG).show();*/
        intent.putExtra("name", name);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}
