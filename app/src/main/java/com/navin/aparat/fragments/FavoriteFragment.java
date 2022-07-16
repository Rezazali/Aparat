package com.navin.aparat.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.aparat.R;
import com.navin.aparat.adapter.VideoAdapter;
import com.navin.aparat.database.AppDatabase;
import com.navin.aparat.databinding.FragmentFavoriteBinding;


public class FavoriteFragment extends Fragment {

    FragmentFavoriteBinding binding;

    AppDatabase appDatabase;


    public FavoriteFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        binding = FragmentFavoriteBinding.inflate(getLayoutInflater());
        appDatabase = AppDatabase.getInstance(getActivity());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        VideoAdapter adapter = new VideoAdapter(getActivity() , appDatabase.idao().videoList());
        binding.recyclerVideos.setAdapter(adapter);

        GridLayoutManager grid = new GridLayoutManager(getActivity() , 2);
        binding.recyclerVideos.setLayoutManager(grid);


    }
}