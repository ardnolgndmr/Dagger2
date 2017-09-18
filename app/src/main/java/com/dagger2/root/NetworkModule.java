package com.dagger2.root;


import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by ardenolgundemir on 13/07/2017.
 */

@Module(includes = ContextModule.class)
public class NetworkModule {

    //HttpLoggingInterceptor
    @Provides
    @GithubApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  httpLoggingInterceptor;
    }


    //Cache
    @Provides
    @GithubApplicationScope
    public Cache cache(File cacheFile){
        return new Cache(cacheFile,10 * 1024 *1024);//cache need file and long mb
    }

    //File
    @Provides
    @GithubApplicationScope
    public File file(Context context){
        return new File(context.getCacheDir(),"okhttp_cache");
    }

    //Okhttpclient
    @Provides
    @GithubApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor) // We need httpLogginInterceptor
                .cache(cache)// we need cache
                .build();
    }



}
