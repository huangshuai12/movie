package com.bw.movie.net;

import com.bw.movie.api.UserApi;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetorUtils {
    public static RetorUtils stanice;
    public Retrofit retrofit;

    public static RetorUtils getStanice() {
        if (stanice==null){
            synchronized (RetorUtils.class){
                if (stanice==null){
                    stanice=new RetorUtils();
                }
            }
        }
        return stanice;
    }
    private RetorUtils(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .addInterceptor(new QinqiuUtils())
                .readTimeout(5,TimeUnit.SECONDS)
                .connectTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();

        retrofit=new Retrofit.Builder()
                .baseUrl(UserApi.ML)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())//就是解析器
                .client(okHttpClient)
                .build();
    }
    public <T>T create(Class<T> tClass){
        return retrofit.create(tClass);
    }
}
