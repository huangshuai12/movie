package com.bw.movie.mvp.model;

import com.bw.movie.entity.JiBean;
import com.bw.movie.entity.LunBean;
import com.bw.movie.entity.RegBean;
import com.bw.movie.entity.ZhengBean;
import com.bw.movie.mvp.contract.LunContract;
import com.bw.movie.net.RetorUtils;
import com.bw.movie.service.UserService;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LunModel implements LunContract.LlunModel {

    @Override
    public void getLun(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getLun(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LunBean>() {
                    @Override
                    public void accept(LunBean lunBean) throws Exception {
                      retorModelCallBack.Success(lunBean);
                    }
                });
    }

    @Override
    public void getRen(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getRen(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<LunBean>() {
                    @Override
                    public void accept(LunBean lunBean) throws Exception {
                       retorModelCallBack.Success(lunBean);
                    }
                });
    }

    @Override
    public void getZheng(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getZheng(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<ZhengBean>() {
                    @Override
                    public void accept(ZhengBean zhengBean) throws Exception {
                        retorModelCallBack.Success(zhengBean);
                    }
                });
    }

    @Override
    public void getJi(HashMap<String, String> map, final RetorModelCallBack retorModelCallBack) {
        RetorUtils.getStanice().create(UserService.class)
                .getJi(map)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<JiBean>() {
                    @Override
                    public void accept(JiBean jiBean) throws Exception {
                        retorModelCallBack.Success(jiBean);
                    }
                });
    }

    public interface RetorModelCallBack{
        void Success(Object result);
    }
}
