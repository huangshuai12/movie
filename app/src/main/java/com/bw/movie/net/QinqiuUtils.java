package com.bw.movie.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class QinqiuUtils implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Object userId = SpUtils.getInstance().getData("userId", "");
        Object sessionId = SpUtils.getInstance().getData("sessionId", "");
        Request.Builder builder = request.newBuilder();
        builder.addHeader("userId", (String) userId);
        builder  .addHeader("sessionId", (String) sessionId);
        Request build = builder.build();
        Response C = chain.proceed(build);
        return C;
    }
}
