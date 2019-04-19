package com.bw.movie.mvp.model;

import com.bw.movie.entity.FuBean;
import com.bw.movie.entity.LunBean;
import com.bw.movie.entity.TuiBean;
import com.bw.movie.mvp.contract.MiddleContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MiddleModel implements MiddleContract.ModdlileModel {


    @Override
    public void getTui(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getTui(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<TuiBean>() {
                    @Override
                    public void accept(TuiBean tuiBean) throws Exception {
                       retorModelCallBack.Success(tuiBean);
                    }
                });
    }

    @Override
    public void getFu(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getFu(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<FuBean>() {
                    @Override
                    public void accept(FuBean fuBean) throws Exception {
                        retorModelCallBack.Success(fuBean);
                    }
                });
    }

    @Override
    public void getGuan(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getGuan(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<TuiBean>() {
                    @Override
                    public void accept(TuiBean tuiBean) throws Exception {
                     retorModelCallBack.Success(tuiBean);
                    }
                });
    }

    @Override
    public void getQu(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getQu(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<TuiBean>() {
                    @Override
                    public void accept(TuiBean tuiBean) throws Exception {
                        retorModelCallBack.Success(tuiBean);
                    }
                });
    }


    public interface RetorModelCallBack{
        void Success(Object result);
    }
}
