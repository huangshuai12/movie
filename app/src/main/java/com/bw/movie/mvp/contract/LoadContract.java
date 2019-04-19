package com.bw.movie.mvp.contract;

import com.bw.movie.entity.LoginBean;
import com.bw.movie.entity.RegBean;
import com.bw.movie.mvp.model.LoadModel;

import java.util.HashMap;

public interface LoadContract {

    //presenter
    public abstract class Lloadpresenter{
        public abstract void getReg(HashMap<String,String> map);
        public abstract void getLogin(HashMap<String,String> map);
        public abstract void getWeiXin(HashMap<String,String> map);
    }
    //model
    interface LloadModel{
        void getReg(HashMap<String,String> map, LoadModel.RetorModelCallBack retorModelCallBack);
        void getLogin(HashMap<String,String> map, LoadModel.RetorModelCallBack retorModelCallBack);
        void getWeiXin(HashMap<String,String> map, LoadModel.RetorModelCallBack retorModelCallBack);
    }
    //view
    interface LloadView{
        void SuccessReg(RegBean regBean);
        void WeiXin(RegBean regBean);
    }

}
