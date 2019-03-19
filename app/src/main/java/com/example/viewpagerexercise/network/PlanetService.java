package com.example.viewpagerexercise.network;

import com.example.viewpagerexercise.model.PlanetList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetService {
    @GET("JDVila/storybook/master/planets.json")
    Call<PlanetList> getPlanetList();
}
