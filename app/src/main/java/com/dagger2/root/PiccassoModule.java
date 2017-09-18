package com.dagger2.root;

import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ardenolgundemir on 18/09/2017.
 */

@Module(includes = ContextModule.class)
public class PiccassoModule {
    @Provides
    public Picasso picasso(Context context){
        return new Picasso.Builder(context).build();
    }
}
