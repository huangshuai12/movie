package com.bw.movie.mvp.contract;

import com.bw.movie.entity.CityBean;
import com.bw.movie.entity.RegBean;
import com.bw.movie.mvp.model.CityModel;
import com.bw.movie.mvp.model.LoadModel;

import java.util.HashMap;

public interface CityContract {
    //presenter
    public abstract class Ccitypresenter{
        public abstract void getCity(HashMap<String,String> map);
        public abstract void getCity1(HashMap<String,String> map);
        public abstract void getCity2(HashMap<String,String> map);
    }
    //model
    interface CcityModel{
        void getCity(HashMap<String,String> map, CityModel.RetorModelCallBack retorModelCallBack);
        void getCity1(HashMap<String,String> map, CityModel.RetorModelCallBack1 retorModelCallBack1);
        void getCity2(HashMap<String,String> map, CityModel.RetorModelCallBack2 retorModelCallBack2);
    }
    //view
    interface CityView{
        void SuccessCity(Object result);
        void SuccessCity1(Object result);
        void SuccessCity2(Object result);
    }
}
