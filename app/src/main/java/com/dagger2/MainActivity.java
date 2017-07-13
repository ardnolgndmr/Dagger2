package com.dagger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dagger2.main.DaggerMainComponent;
import com.dagger2.main.MainActivityModule;
import com.dagger2.main.MainComponent;
import com.dagger2.webservices.Webservices;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Webservices webservices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainComponent component = DaggerMainComponent.builder()
                .mainActivityModule(new MainActivityModule(this))
                .daggerApplicationComponent(MainApplication.get(this).component()).build();

        component.injectHomeActivity(this);

        if (webservices != null){

        }
    }
}
