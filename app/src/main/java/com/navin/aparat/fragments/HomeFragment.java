package com.navin.aparat.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.navin.aparat.R;
import com.navin.aparat.adapter.NewsAdapter;
import com.navin.aparat.adapter.VideoAdapter;
import com.navin.aparat.models.IResponseListener;
import com.navin.aparat.models.News;
import com.navin.aparat.models.Video;
import com.navin.aparat.webservice.ApiClient;
import com.navin.aparat.webservice.IService;
import com.navin.aparat.webservice.WebserviceCaller;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {


    RecyclerView recycler_new_videos;
    RecyclerView recycler_best_videos;
    RecyclerView recycler_special_videos;

    WebserviceCaller webserviceCaller;

    ViewPager news_pager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_new_videos = view.findViewById(R.id.recycler_new_videos);
        recycler_best_videos = view.findViewById(R.id.recycler_best_videos);
        recycler_special_videos = view.findViewById(R.id.recycler_special_videos);
        news_pager = view.findViewById(R.id.news_pager);


        webserviceCaller = new WebserviceCaller();

        webserviceCaller.getNewVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                List<Video> videoList =(List<Video>)responseMessage;

                VideoAdapter adapter = new VideoAdapter(getActivity(), videoList);
                recycler_new_videos.setAdapter(adapter);

                LinearLayoutManager manager = new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL, false);

                recycler_new_videos.setLayoutManager(manager);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });

        webserviceCaller.getBestVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                VideoAdapter adapter = new VideoAdapter(getActivity(), (List<Video>) responseMessage);
                recycler_best_videos.setAdapter(adapter);

                LinearLayoutManager manager = new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL, false);

                recycler_best_videos.setLayoutManager(manager);
            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });


        webserviceCaller.getSpecialVideos(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                VideoAdapter adapter = new VideoAdapter(getActivity(), (List<Video>) responseMessage);
                recycler_special_videos.setAdapter(adapter);

                LinearLayoutManager manager = new LinearLayoutManager(getActivity(),
                        LinearLayoutManager.HORIZONTAL, false);

                recycler_special_videos.setLayoutManager(manager);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });


        webserviceCaller.getNews(new IResponseListener() {
            @Override
            public void onSuccess(Object responseMessage) {

                NewsAdapter adapter = new NewsAdapter(getActivity() , (List<News>)responseMessage);
                news_pager.setAdapter(adapter);

            }

            @Override
            public void onFailure(String errorResponseMessage) {

            }
        });


        return view;
    }
}