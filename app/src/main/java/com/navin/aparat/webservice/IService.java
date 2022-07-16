package com.navin.aparat.webservice;

import com.navin.aparat.models.Category;
import com.navin.aparat.models.News;
import com.navin.aparat.models.Video;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IService {


    @GET("getNewVideos.php")
    Call<List<Video>> newVideos();

    @GET("getBestVideos.php")
    Call<List<Video>> getBestVideos();

    @GET("getSpecial.php")
    Call<List<Video>> getSpecial();

    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> login(@Field("username") String user , @Field("password") String pass );


    @GET("getNews.php")
    Call<List<News>> getNewsList();

    @GET("getCategory.php")
    Call<List<Category>> getCategoriesList();

}
