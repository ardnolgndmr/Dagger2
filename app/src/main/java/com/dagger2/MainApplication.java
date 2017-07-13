package com.dagger2;

import android.app.Activity;
import android.app.Application;

import com.dagger2.root.ContextModule;
import com.dagger2.root.DaggerApplicationComponent;
import com.dagger2.root.DaggerDaggerApplicationComponent;

import timber.log.Timber;

/**
 * Created by ardenolgundemir on 13/07/2017.
 */

public class MainApplication extends Application {

    private DaggerApplicationComponent component;

    public static MainApplication get(Activity activity) {
        return (MainApplication) activity.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        component = DaggerDaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();


    }


    public DaggerApplicationComponent component() {
        return component;
    }

}
