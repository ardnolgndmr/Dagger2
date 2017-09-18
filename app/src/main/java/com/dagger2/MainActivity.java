package com.dagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dagger2.main.DaggerMainComponent;
import com.dagger2.main.MainActivityModule;
import com.dagger2.main.MainComponent;
import com.dagger2.model.GithubRepo;
import com.dagger2.webservices.Webservices;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity{

    @Inject
    Webservices webservices;

    @Inject
    Picasso picasso;

    Call<List<GithubRepo>> reposCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        MainComponent component = DaggerMainComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .daggerApplicationComponent(MainApplication.get(this).component()).build();

        component.injectHomeActivity(this);

        if (webservices != null){
            reposCall = webservices.getAllRepos();
            reposCall.enqueue(new Callback<List<GithubRepo>>() {
                @Override
                public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                    if (response.body() != null){

                    }
                }

                @Override
                public void onFailure(Call<List<GithubRepo>> call, Throwable t) {

                }
            });

        }

        if (picasso != null){
            Timber.i("YES I HAVE PICASSO");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(reposCall != null) {
            reposCall.cancel();
        }
    }
}
