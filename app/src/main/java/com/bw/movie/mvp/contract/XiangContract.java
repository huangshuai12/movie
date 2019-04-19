package com.bw.movie.mvp.contract;

import com.bw.movie.mvp.model.XiangModel;

import java.util.HashMap;

import retrofit2.http.Header;

public interface XiangContract {
    //presenter
    public abstract class Xxiangpresenter{
        public abstract void getXiang(@Header("userId") String userId, @Header("sessionId") String sessionId,HashMap<String,String> map);
    }
    //model
    interface XxinangModel{
        void getXiang(@Header("userId") String userId, @Header("sessionId") String sessionId, HashMap<String,String> map, XiangModel.RetorModelCallBack retorModelCallBack);
    }
    //view
    interface XxiangView{
        void SuccessXiang(Object result);
    }
}
