package com.bw.movie.mvp.presenter;

import com.bw.movie.entity.SelectMovie;
import com.bw.movie.mvp.contract.MyMovieContract;
import com.bw.movie.mvp.model.MyMovieModel;

import java.util.HashMap;

public class MyMoviePressenter extends MyMovieContract.MyMoviewPresenter {
    private MyMovieModel myMovieModel;
    private MyMovieContract.MyMoviewView myMoviewView;

    public MyMoviePressenter(MyMovieContract.MyMoviewView myMoviewView) {
        this.myMoviewView = myMoviewView;
        myMovieModel = new MyMovieModel();
    }


    @Override
    public void getMovie(HashMap<String, String> map) {
      myMovieModel.getMyMoview(map, new MyMovieModel.RetorModelCallBack() {
          @Override
          public void Success(SelectMovie selectMovie) {
              myMoviewView.SuccessMoview(selectMovie);
          }
      });
    }
}
