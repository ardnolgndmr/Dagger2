package com.dagger2.root;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ardenolgundemir on 13/07/2017.
 */

@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    public Context context(){
        return this.context;
    }

}
