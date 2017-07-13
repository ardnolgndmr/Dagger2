package com.dagger2.webservices;

import com.dagger2.model.GithubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ardenolgundemir on 13/07/2017.
 */

public interface Webservices {
    @GET("repositories")
    Call<List<GithubRepo>> getAllRepos();
}
