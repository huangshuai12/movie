package com.bw.movie.mvp.contract;

import com.bw.movie.mvp.model.CityChenModel;
import com.bw.movie.mvp.model.CityModel;

import java.util.HashMap;

public interface CityChenContract {
    //presenter
    public abstract class CcityChenpresenter{
        public abstract void getCity(HashMap<String,String> map);
    }
    //model
    interface CcityChenModel{
        void getCity(HashMap<String,String> map, CityChenModel.RetorCallBack retorCallBack );

    }
    //view
    interface CityChenView{
        void SuccessCityChen(Object result);
    }
}
