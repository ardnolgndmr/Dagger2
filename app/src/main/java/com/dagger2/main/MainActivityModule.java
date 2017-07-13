package com.dagger2.main;

import com.dagger2.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ardenolgundemir on 13/07/2017.
 */

@Module
public class MainActivityModule {

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    private final MainActivity mainActivity;

    @Provides
    @MainActivityScope
    public MainActivity homeActivity() {
        return mainActivity;
    }
}
