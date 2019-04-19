package com.bw.movie.mvp;

import android.app.Application;
import android.os.Environment;

import com.bw.movie.net.SpUtils;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //缓存图片
        DiskCacheConfig builder = DiskCacheConfig.newBuilder(this)
                .setBaseDirectoryName("image")
                .setBaseDirectoryPath(Environment.getExternalStorageDirectory())
                .build();
        ImagePipelineConfig builder1 = ImagePipelineConfig.newBuilder(this)
                .setMainDiskCacheConfig(builder)
                .build();
        Fresco.initialize(this,builder1);
        SpUtils.init(getApplicationContext());
    }
}
