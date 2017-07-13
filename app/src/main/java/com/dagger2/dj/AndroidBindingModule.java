package com.dagger2.dj;

import com.dagger2.home.HomeActivity;
import com.dagger2.home.HomeActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class AndroidBindingModule {
    @ContributesAndroidInjector(modules = {HomeActivityModule.class})
    abstract HomeActivity contributesMainActivity();
}
