package com.bw.movie.mvp.contract;

import com.bw.movie.entity.RegBean;
import com.bw.movie.mvp.model.LunModel;

import java.util.HashMap;

public interface LunContract {
    //presenter
    public abstract class Llunpresenter{
        public abstract void getLun(HashMap<String,String> map);
        public abstract void getRen(HashMap<String,String> map);
        public abstract void getLZheng(HashMap<String,String> map);
        public abstract void getJi(HashMap<String,String> map);
    }
    //model
    interface LlunModel{
        void getLun(HashMap<String,String> map, LunModel.RetorModelCallBack retorModelCallBack);
        void getRen(HashMap<String,String> map, LunModel.RetorModelCallBack retorModelCallBack);
        void getZheng(HashMap<String,String> map, LunModel.RetorModelCallBack retorModelCallBack);
        void getJi(HashMap<String,String> map, LunModel.RetorModelCallBack retorModelCallBack);
    }
    //view
    interface LlunView{
        void SuccessLun(Object result);
        void SuccessRen(Object result);
        void SuccessZheng(Object result);
        void SuccessJi(Object result);
    }
}
