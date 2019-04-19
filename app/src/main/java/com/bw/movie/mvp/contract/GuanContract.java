package com.bw.movie.mvp.contract;

import com.bw.movie.mvp.model.CityModel;
import com.bw.movie.mvp.model.GuanModel;

import java.util.HashMap;

public interface GuanContract {
    //presenter
    public abstract class Gguanpresenter{
        public abstract void getGuan(HashMap<String,String> map);
        public abstract void getQu(HashMap<String,String> map);
    }
    //model
    interface GguanModel{
        void getGuan(HashMap<String,String> map, GuanModel.RetorModelCallBack retorModelCallBack);
        void getQu(HashMap<String,String> map,GuanModel.RetorModelCallBack1 retorModelCallBack1);
    }
    //view
    interface GguanView{
        void SuccessGuan(Object result);
        void SuccessQu(Object result);
    }


}
