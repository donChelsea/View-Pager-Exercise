package com.example.viewpagerexercise;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPagerFragment extends Fragment {
    private static final String PLANET_NAME = "planet name";
    private static final String PLANET_NUMBER = "planet number";
    private static final String PLANET_IMAGE = "planet image";
    private String planetName;
    private String planetNumber;
    private String planetImage;
    private TextView planetNameTv;
    private TextView planetNumberTv;
    private ImageView planetIv;


    public ViewPagerFragment() {
    }

    public ViewPagerFragment newInstance(String planetName, String planetNumber, String planetImage) {
        Bundle args = new Bundle();
        args.putString(PLANET_NAME, planetName);
        args.putString(PLANET_NUMBER, planetNumber);
        args.putString(PLANET_IMAGE, planetImage);
        ViewPagerFragment vpf = new ViewPagerFragment();
        vpf.setArguments(args);
        return vpf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;

        planetName = getArguments().getString(PLANET_NAME);
        planetNumber = getArguments().getString(PLANET_NUMBER);
        planetImage = getArguments().getString(PLANET_IMAGE);

        planetNameTv = view.findViewById(R.id.planet_name_textview);
        planetNumberTv = view.findViewById(R.id.planet_number_textview);
        planetIv = view.findViewById(R.id.planet_imageview);

        planetNameTv.setText(planetName);
        planetNumberTv.setText(planetNumber);
        Picasso.get().load(planetImage).into(planetIv);
    }
}
