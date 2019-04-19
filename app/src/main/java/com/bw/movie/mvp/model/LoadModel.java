package com.bw.movie.mvp.model;

import android.annotation.SuppressLint;

import com.bw.movie.R;
import com.bw.movie.entity.RegBean;
import com.bw.movie.mvp.contract.LoadContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoadModel implements LoadContract.LloadModel {


    @SuppressLint("CheckResult")
    @Override
    public void getReg(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getReg(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RegBean>() {
                    @Override
                    public void accept(RegBean regBean) throws Exception {
                        retorModelCallBack.Success(regBean);
                    }
                });
    }

    @Override
    public void getLogin(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getLogin(map)
                . observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RegBean>() {
                    @Override
                    public void accept(RegBean regBean) throws Exception {
                        retorModelCallBack.Success(regBean);
                    }
                });
    }

    @Override
    public void getWeiXin(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getWeiXin(map)
                . observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RegBean>() {
                    @Override
                    public void accept(RegBean regBean) throws Exception {
                        retorModelCallBack.Success(regBean);
                    }
                });
    }


    //modle
    public interface RetorModelCallBack{
        void Success(RegBean regBean);
    }
}
