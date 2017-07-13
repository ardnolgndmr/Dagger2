package com.dagger2.home;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {
    @Provides
    HomeContract.View provideMainView(HomeActivity homeActivity){
        return homeActivity;
    }

    @Provides
    HomePresenter provideMainPresenter(HomeContract.View mainView){
        return new HomePresenter(mainView);
    }
}
