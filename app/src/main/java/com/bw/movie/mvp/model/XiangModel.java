package com.bw.movie.mvp.model;

import com.bw.movie.entity.LunBean;
import com.bw.movie.entity.XiangBean;
import com.bw.movie.mvp.contract.XiangContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class XiangModel implements XiangContract.XxinangModel {


    @Override
    public void getXiang(String userId, String sessionId, HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getXiang(map,userId,sessionId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<XiangBean>() {
                    @Override
                    public void accept(XiangBean xiangBean) throws Exception {
                        retorModelCallBack.Success(xiangBean);
                    }
                });
    }

    public interface RetorModelCallBack{
        void Success(Object result);
    }
}
