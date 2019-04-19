package com.bw.movie.fragment.myfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bw.movie.R;
import com.bw.movie.entity.SelectMovie;
import com.bw.movie.entity.TuiBean;
import com.bw.movie.mvp.contract.MiddleContract;
import com.bw.movie.mvp.contract.MyMovieContract;
import com.bw.movie.mvp.myAdpater.MyMovieAdapter;
import com.bw.movie.mvp.myAdpater.TuiAdapter.TuiAdapter;
import com.bw.movie.mvp.presenter.Middlepresenter;
import com.bw.movie.mvp.presenter.MyMoviePressenter;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class myonefragment extends Fragment implements MyMovieContract.MyMoviewView,MiddleContract.ModdileView {
    @BindView(R.id.My_Rec)
    RecyclerView MyRec;
    Unbinder unbinder;
    private MyMoviePressenter myMoviePressenter;
    private MyMovieAdapter myMovieAdapter;
    private Middlepresenter middlepresenter;
    private TuiAdapter tuiAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_movie_one, container, false);
        unbinder = ButterKnife.bind(this, view);
    /*    myMoviePressenter = new MyMoviePressenter(this);
        myMovieAdapter = new MyMovieAdapter(getActivity());
        *//*MyRec.setLayoutManager(new LinearLayoutManager(getActivity()));*//*
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        MyRec.setLayoutManager(linearLayoutManager);

        HashMap<String,String> map = new HashMap<>();
        map.put("page","1");
        map.put("count","10");
        myMoviePressenter.getMovie(map);*/


        middlepresenter = new Middlepresenter(this);
        tuiAdapter = new TuiAdapter(getActivity());
        MyRec.setLayoutManager(new LinearLayoutManager(getActivity()));
        HashMap<String,String> map = new HashMap<>();
        map.put("page",1+"");
        map.put("count",6+"");
        middlepresenter.getTui(map);
        return view;
    }

    @Override
    public void SuccessMoview(Object result) {
        SelectMovie selectMovie=(SelectMovie) result;
        List<SelectMovie.ResultBean> result1 = selectMovie.getResult();
        myMovieAdapter.setList(result1);
        MyRec.setAdapter(myMovieAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void SuccessTui(Object result) {
        TuiBean tuiBean=(TuiBean) result;
        List<TuiBean.ResultBean> result1 = tuiBean.getResult();
        MyRec.setAdapter(tuiAdapter);
        tuiAdapter.setList(result1);
    }

    @Override
    public void SuccessFu(Object result) {

    }

    @Override
    public void SuccessGuan(Object result) {

    }

    @Override
    public void SuccessQu(Object result) {

    }
}
