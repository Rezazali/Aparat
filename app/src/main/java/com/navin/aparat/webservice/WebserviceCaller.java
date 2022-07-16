package com.navin.aparat.webservice;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.navin.aparat.adapter.VideoAdapter;
import com.navin.aparat.models.Category;
import com.navin.aparat.models.IResponseListener;
import com.navin.aparat.models.News;
import com.navin.aparat.models.Video;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    IService iService;

    public WebserviceCaller() {
        iService = ApiClient.getRetrofit().create(IService.class);
    }

    public void getNewVideos(IResponseListener listener) {


        iService.newVideos().enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {

                Log.e("", "");
                listener.onSuccess(response.body());


            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                Log.e("", "");
                listener.onFailure("Error");
            }

        });

    }

    public void getBestVideos(IResponseListener listener) {


        iService.getBestVideos().enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {
                listener.onSuccess(response.body());

            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString());
            }
        });

    }

    public void getSpecialVideos(IResponseListener listener) {


        iService.getSpecial().enqueue(new Callback<List<Video>>() {
            @Override
            public void onResponse(Call<List<Video>> call, Response<List<Video>> response) {

                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Video>> call, Throwable t) {

                listener.onFailure(t.getMessage().toString());

            }
        });


    }

    public void getNews(IResponseListener listener) {


        iService.getNewsList().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                listener.onFailure(t.getMessage().toString());
            }
        });


    }

    public void getCategories(IResponseListener listener) {

        iService.getCategoriesList().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                listener.onSuccess(response.body());


            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

                listener.onFailure(t.getMessage().toString());


            }
        });

    }


}
