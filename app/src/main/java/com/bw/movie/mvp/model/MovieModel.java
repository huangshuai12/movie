package com.bw.movie.mvp.model;

import com.bw.movie.entity.CityBean;
import com.bw.movie.entity.MovieBean1;
import com.bw.movie.entity.MovieBean2;
import com.bw.movie.entity.MovieBean3;
import com.bw.movie.mvp.contract.MovieContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MovieModel implements MovieContract.MmovieModel {


    @Override
    public void getCity(HashMap<String, String> map, final RetorCallBack retorCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getMovie1(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MovieBean1>() {
                    @Override
                    public void accept(MovieBean1 movieBean1) throws Exception {
                     retorCallBack.Success(movieBean1);
                    }
                });
    }

    @Override
    public void getCity3(HashMap<String, String> map, final RetorCallBack3 retorCallBack3) {
        RetorUtils.getStanice().create(UserService.class)
                .getMovie3(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MovieBean3>() {
                    @Override
                    public void accept(MovieBean3 movieBean3) throws Exception {
                       retorCallBack3.Success(movieBean3);
                    }
                });
    }

    @Override
    public void getCity1(HashMap<String, String> map, final RetorCallBack1 retorCallBack1) {
        RetorUtils.getStanice().create(UserService.class)
                .getMovie2(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<MovieBean2>() {
                    @Override
                    public void accept(MovieBean2 movieBean2) throws Exception {
                        retorCallBack1.Success(movieBean2);
                    }
                });
    }

    public interface  RetorCallBack{
        void Success(MovieBean1 movieBean1);
    }
    public interface  RetorCallBack1{
        void Success(MovieBean2 movieBean2);
    }
    public interface  RetorCallBack3{
        void Success(MovieBean3 movieBean3);
    }
}
