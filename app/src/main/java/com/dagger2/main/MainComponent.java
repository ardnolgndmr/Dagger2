package com.dagger2.main;

import com.dagger2.MainActivity;
import com.dagger2.root.DaggerApplicationComponent;

import dagger.Component;

/**
 * Created by ardenolgundemir on 13/07/2017.
 */
@MainActivityScope
@Component(modules = MainActivityModule.class,dependencies = DaggerApplicationComponent.class)
public interface MainComponent {
    void injectHomeActivity(MainActivity homeActivity);
}
