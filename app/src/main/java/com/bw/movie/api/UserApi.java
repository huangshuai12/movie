package com.bw.movie.api;

import android.widget.ScrollView;

public class UserApi {
    //接口
    public static final String ML="http://mobile.bwstudent.com/";
    //注册
    public static final String REG="movieApi/user/v1/registerUser";
    //登录
    public static final String LOGIN="movieApi/user/v1/login";
    //轮播
    public static final String LUN_BO="movieApi/movie/v1/findHotMovieList";
    //热门
    public static final String REN_Men="movieApi/movie/v1/findHotMovieList";
    //正在热映
    public static final String Zheng_Zai="movieApi/movie/v1/findReleaseMovieList";
    //即将热映
    public static final String Ji_Jiang="movieApi/movie/v1/findComingSoonMovieList";
    //详情页面
    public static final String XIANG_QING="movieApi/movie/v1/findMoviesDetail";
    //推荐
    public static final String TUI_JIAN="movieApi/cinema/v1/findRecommendCinemas";
    //附近
    public static final String FU_JIN="movieApi/cinema/v1/findNearbyCinemas";
    //查看评论
    public static final String PING_lUN=" movieApi/movie/v1/findAllMovieComment";
    //第二one
    public static final String YING_CITY="movieApi/cinema/v1/findCinemaInfo";
    //第二two
    public static final String LUN_CITY="movieApi/movie/v1/findMovieListByCinemaId";
    //第二three
    public static final String Zhan_CITY="movieApi/movie/v1/findMovieScheduleList";
    //关注
    public static final String Guan_Zhu="movieApi/cinema/v1/verify/followCinema";
    //取消关注
    public static final String Qu_Xiao="movieApi/cinema/v1/verify/cancelFollowCinema";
    //查看影院关注
    public static final String YING_YUAN_MOVIE="movieApi/cinema/v1/verify/findCinemaPageList";
    //微信登录
    public static final String WEIXin="movieApi/user/v1/weChatBindingLogin";
    //
    public static final String CITY_CHENG_BEAN="movieApi/cinema/v1/findCinemaInfo";
    //根据电影ID查询当前排片该电影的影院列表
    public static final String movieApi1="movieApi/movie/v1/findCinemasListByMovieId";

    //
    public static final String  moviewApi3="movieApi/movie/v1/findMoviesById";
    //根据电影ID和影院ID查询电影排期列表
    public static final String movieApi2="movieApi/movie/v1/findMovieScheduleList";
}
