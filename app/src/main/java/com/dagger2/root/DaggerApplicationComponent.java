package com.dagger2.root;

import com.dagger2.webservices.Webservices;

import dagger.Component;

/**
 * Created by ardenolgundemir on 13/07/2017.
 */

@GithubApplicationScope
@Component(modules = {WebServiceModule.class})
public interface DaggerApplicationComponent {
    Webservices webservices();
}
