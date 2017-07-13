package com.dagger2.root;

import com.dagger2.webservices.Webservices;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ardenolgundemir on 13/07/2017.
 */

@Module(includes = NetworkModule.class)
public class WebServiceModule {

    @Provides
    @GithubApplicationScope
    public Webservices webservices(Retrofit retrofit){
        return retrofit.create(Webservices.class);
    }


    @Provides
    @GithubApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, GsonConverterFactory provideGsonConverter){
        return new Retrofit.Builder()
                .addConverterFactory(provideGsonConverter)
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();
    }

    @Provides
    @GithubApplicationScope
    GsonConverterFactory provideGsonConverter() {
        return GsonConverterFactory.create(new Gson());

    }
}
