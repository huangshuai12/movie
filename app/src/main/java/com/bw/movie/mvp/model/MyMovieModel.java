package com.bw.movie.mvp.model;

import com.bw.movie.entity.SelectMovie;
import com.bw.movie.entity.TuiBean;
import com.bw.movie.mvp.contract.MyMovieContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MyMovieModel implements MyMovieContract.MyMoviewModel {


    @Override
    public void getMyMoview(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getSelectMovie(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<SelectMovie>() {
                    @Override
                    public void accept(SelectMovie selectMovie) throws Exception {
                       retorModelCallBack.Success(selectMovie);
                    }
                });
    }

    public interface RetorModelCallBack{
        void Success(SelectMovie selectMovie);
    }
}
