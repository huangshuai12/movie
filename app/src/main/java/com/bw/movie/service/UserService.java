package com.bw.movie.service;

import com.bw.movie.api.UserApi;
import com.bw.movie.entity.CityBean;
import com.bw.movie.entity.CityChengBean;
import com.bw.movie.entity.CityLunBean;
import com.bw.movie.entity.CityZhanBean;
import com.bw.movie.entity.FuBean;
import com.bw.movie.entity.GuanZhuBean;
import com.bw.movie.entity.JiBean;
import com.bw.movie.entity.LoginBean;
import com.bw.movie.entity.LunBean;
import com.bw.movie.entity.MovieBean1;
import com.bw.movie.entity.MovieBean2;
import com.bw.movie.entity.MovieBean3;
import com.bw.movie.entity.PingBean;
import com.bw.movie.entity.QuBean;
import com.bw.movie.entity.RegBean;
import com.bw.movie.entity.SelectMovie;
import com.bw.movie.entity.TuiBean;
import com.bw.movie.entity.XiangBean;
import com.bw.movie.entity.ZhengBean;

import java.util.HashMap;
import java.util.logging.Handler;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface UserService {
    @POST(UserApi.REG)
    @FormUrlEncoded
    Observable<RegBean> getReg(@FieldMap HashMap<String,String> map);

    @POST(UserApi.LOGIN)
    @FormUrlEncoded
    Observable<RegBean> getLogin(@FieldMap HashMap<String,String> map);

    //轮播
    @GET(UserApi.LUN_BO)
    Observable<LunBean> getLun(@QueryMap HashMap<String,String> map);

    @GET(UserApi.REN_Men)
    Observable<LunBean> getRen(@QueryMap HashMap<String,String> map);

    @GET(UserApi.Zheng_Zai)
    Observable<ZhengBean> getZheng(@QueryMap HashMap<String,String> map);

    @GET(UserApi.Ji_Jiang)
    Observable<JiBean> getJi(@QueryMap HashMap<String,String> map);
    //详情
    @GET(UserApi.XIANG_QING)
    Observable<XiangBean> getXiang(@QueryMap HashMap<String,String> map, @Header("userId") String userId, @Header("sessionId") String sessionId);
    //推荐
    @GET(UserApi.TUI_JIAN)
    Observable<TuiBean> getTui(@QueryMap HashMap<String,String> map);
    //附近
    @GET(UserApi.FU_JIN)
    Observable<FuBean> getFu(@QueryMap HashMap<String,String> map);
    //评论
    @GET(UserApi.PING_lUN)
    Observable<PingBean> getPing(@QueryMap HashMap<String,String> map);
    //城市
    @GET(UserApi.YING_CITY)
    Observable<CityBean> getCity(@QueryMap HashMap<String,String> map);
    //城市
    @GET(UserApi.LUN_CITY)
    Observable<CityLunBean> getCity1(@QueryMap HashMap<String,String> map);
    //城市
    @GET(UserApi.Zhan_CITY)
    Observable<CityZhanBean> getCity2(@QueryMap HashMap<String,String> map);
    //关注
    @GET(UserApi.Guan_Zhu)
    Observable<TuiBean> getGuan(@QueryMap HashMap<String,String> map);
    //城市
    @GET(UserApi.Qu_Xiao)
    Observable<TuiBean>  getQu(@QueryMap HashMap<String,String> map);
    //关注影院
    @GET(UserApi.YING_YUAN_MOVIE)
    Observable<SelectMovie>  getSelectMovie(@QueryMap HashMap<String,String> map);

    @FormUrlEncoded
    @POST(UserApi.WEIXin)
    Observable<RegBean>  getWeiXin(@FieldMap HashMap<String,String> map);

    @GET(UserApi.CITY_CHENG_BEAN)
    Observable<CityChengBean>  getCheng(@QueryMap HashMap<String,String> map);

    @GET(UserApi.movieApi1)
    Observable<MovieBean1>  getMovie1(@QueryMap HashMap<String,String> map);

    @GET(UserApi.movieApi2)
    Observable<MovieBean2>  getMovie2(@QueryMap HashMap<String,String> map);

    @GET(UserApi.moviewApi3)
    Observable<MovieBean3>  getMovie3(@QueryMap HashMap<String,String> map);

}
