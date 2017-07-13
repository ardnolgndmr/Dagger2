package com.dagger2.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dagger2.R;

import dagger.android.AndroidInjection;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AndroidInjection.inject(this);
    }
}
