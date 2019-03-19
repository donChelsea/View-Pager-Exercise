package com.example.viewpagerexercise;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.viewpagerexercise.model.Planet;
import com.example.viewpagerexercise.model.PlanetList;
import com.example.viewpagerexercise.network.PlanetService;
import com.example.viewpagerexercise.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";
    private List<Fragment> fragmentList = new ArrayList<>();
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new RetrofitSingleton().newInstance();
        PlanetService planetService = retrofit.create(PlanetService.class);
        Call<PlanetList> planetListCall = planetService.getPlanetList();
        planetListCall.enqueue(new Callback<PlanetList>() {
            @Override
            public void onResponse(Call<PlanetList> call, Response<PlanetList> response) {
                List<Planet> planets = response.body().getPlanetList();
                for (Planet planet: planets) {
                    fragmentList.add(new ViewPagerFragment().newInstance(planet.getName(), planet.getNumber(), planet.getImage()));
                }
                ViewPager viewPager = findViewById(R.id.view_pager);
                viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList));
            }

            @Override
            public void onFailure(Call<PlanetList> call, Throwable t) {
                Log.d(TAG, "onFailure:---" + t.getMessage());
            }
        });

    }

}
