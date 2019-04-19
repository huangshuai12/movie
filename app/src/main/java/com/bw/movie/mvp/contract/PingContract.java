package com.bw.movie.mvp.contract;

import com.bw.movie.mvp.model.PingModel;

import java.util.HashMap;

public interface PingContract {

    public abstract class PpingPresenter{
        public abstract void getPing(HashMap<String,String> map);
    }
    //model
    interface PpingModel{
        void getPing(HashMap<String,String> map, PingModel.RetorModelCallBack retorModelCallBack);
    }
    //view
    interface PpingView{
        void SuccessPing(Object result);
    }
}
