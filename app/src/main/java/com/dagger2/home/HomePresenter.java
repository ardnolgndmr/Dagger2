package com.dagger2.home;

import javax.inject.Inject;

public class HomePresenter implements HomeContract.Presenter {

    @Inject
    public HomePresenter(final HomeContract.View homeView) {
    }
}
