package com.bw.movie.mvp.contract;

import com.bw.movie.mvp.model.GuanModel;
import com.bw.movie.mvp.model.LunModel;
import com.bw.movie.mvp.model.MiddleModel;

import java.util.HashMap;

public interface MiddleContract {
    //presenter
    public abstract class Moddilepresenter{
        public abstract void getTui(HashMap<String,String> map);
        public abstract void getFu(HashMap<String,String> map);


        public abstract void getGuan(HashMap<String,String> map);
        public abstract void getQu(HashMap<String,String> map);
    }
    //model
    interface ModdlileModel{
        void getTui(HashMap<String,String> map, MiddleModel.RetorModelCallBack retorModelCallBack);
        void getFu(HashMap<String,String> map, MiddleModel.RetorModelCallBack retorModelCallBack);

        void getGuan(HashMap<String,String> map, MiddleModel.RetorModelCallBack retorModelCallBack);
        void getQu(HashMap<String,String> map,MiddleModel.RetorModelCallBack retorModelCallBack);
    }
    //view
    interface ModdileView{
        void SuccessTui(Object result);
        void SuccessFu(Object result);

        void SuccessGuan(Object result);
        void SuccessQu(Object result);
    }
}
