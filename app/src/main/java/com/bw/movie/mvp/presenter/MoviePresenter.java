package com.bw.movie.mvp.presenter;

import com.bw.movie.entity.MovieBean1;
import com.bw.movie.entity.MovieBean2;
import com.bw.movie.entity.MovieBean3;
import com.bw.movie.mvp.contract.MovieContract;
import com.bw.movie.mvp.model.MovieModel;

import java.util.HashMap;

public class MoviePresenter extends MovieContract.Mmoviepresenter {
    private final MovieModel movieModel;
    private MovieContract.MmovieView mmovieView;

    public MoviePresenter(MovieContract.MmovieView mmovieView) {
        this.mmovieView = mmovieView;
        movieModel = new MovieModel();
    }

    @Override
    public void getCity(final HashMap<String, String> map) {
        movieModel.getCity(map, new MovieModel.RetorCallBack() {
            @Override
            public void Success(MovieBean1 movieBean1) {
                mmovieView.SuccessCity(movieBean1);
            }
        });
    }

    @Override
    public void getCity1(final HashMap<String, String> map) {
        movieModel.getCity1(map, new MovieModel.RetorCallBack1() {
            @Override
            public void Success(MovieBean2 movieBean2) {
                movieModel.getCity1(map, new MovieModel.RetorCallBack1() {
                    @Override
                    public void Success(MovieBean2 movieBean2) {
                        mmovieView.SuccessCity1(movieBean2);
                    }
                });
            }
        });
    }

    @Override
    public void getCity3(HashMap<String, String> map) {
        movieModel.getCity3(map, new MovieModel.RetorCallBack3() {
            @Override
            public void Success(MovieBean3 movieBean3) {
                mmovieView.SuccessCity3(movieBean3);
            }
        });
    }
}
