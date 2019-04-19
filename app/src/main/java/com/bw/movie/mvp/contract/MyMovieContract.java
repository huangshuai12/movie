package com.bw.movie.mvp.contract;

import com.bw.movie.mvp.model.MyMovieModel;


import java.util.HashMap;

public interface MyMovieContract {

    public abstract class MyMoviewPresenter{
        public abstract void getMovie(HashMap<String,String> map);
    }
    //model
    interface MyMoviewModel{
        void getMyMoview(HashMap<String,String> map, MyMovieModel.RetorModelCallBack retorModelCallBack);
    }
    //view
    interface MyMoviewView{
        void SuccessMoview(Object result);
    }
}
