package com.navin.aparat.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.aparat.R;
import com.navin.aparat.adapter.CategoryAdapter;
import com.navin.aparat.databinding.FragmentCategoryBinding;
import com.navin.aparat.models.Category;
import com.navin.aparat.models.IResponseListener;
import com.navin.aparat.webservice.WebserviceCaller;

import java.util.List;


public class CategoryFragment extends Fragment {


    FragmentCategoryBinding binding;

    WebserviceCaller webserviceCaller;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(getLayoutInflater());
        webserviceCaller = new WebserviceCaller();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.progressBar.setVisibility(View.VISIBLE);
        webserviceCaller.getCategories(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                binding.progressBar.setVisibility(View.GONE);
                CategoryAdapter adapter = new CategoryAdapter(getActivity() ,(List<Category>) responseMessage);
                binding.recyclerCategory.setAdapter(adapter);

                LinearLayoutManager manager= new LinearLayoutManager(getActivity() ,
                        RecyclerView.VERTICAL ,false);

                binding.recyclerCategory.setLayoutManager(manager);



            }

            @Override
            public void onFailure(String errorResponseMessage) {
                binding.progressBar.setVisibility(View.GONE);
            }
        });


    }
}