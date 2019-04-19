package com.bw.movie.mvp.model;

import com.bw.movie.entity.PingBean;
import com.bw.movie.entity.TuiBean;
import com.bw.movie.mvp.contract.LoadContract;
import com.bw.movie.mvp.contract.PingContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PingModel implements PingContract.PpingModel {


    @Override
    public void getPing(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getPing(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<PingBean>() {
                    @Override
                    public void accept(PingBean pingBean) throws Exception {
                        retorModelCallBack.Success(pingBean);
                    }
                });
    }

    public   interface RetorModelCallBack{
        void Success(Object result);
    }
}
