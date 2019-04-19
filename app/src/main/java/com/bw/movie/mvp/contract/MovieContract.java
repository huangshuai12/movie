package com.bw.movie.mvp.contract;

import com.bw.movie.mvp.model.CityModel;
import com.bw.movie.mvp.model.MovieModel;

import java.util.HashMap;

public interface MovieContract {
    //presenter
    public abstract class Mmoviepresenter{
        public abstract void getCity(HashMap<String,String> map);
        public abstract void getCity1(HashMap<String,String> map);
        public abstract void getCity3(HashMap<String,String> map);
    }
    //model
    interface MmovieModel{
        void getCity(HashMap<String,String> map, MovieModel.RetorCallBack retorCallBack);
        void getCity1(HashMap<String,String> map, MovieModel.RetorCallBack1 retorCallBack1);
        void getCity3(HashMap<String,String> map, MovieModel.RetorCallBack3 retorCallBack3);
    }
    //view
    interface MmovieView{
        void SuccessCity(Object result);
        void SuccessCity1(Object result);
        void SuccessCity3(Object result);
    }
}
