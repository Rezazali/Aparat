package com.navin.aparat.models;

public interface IResponseListener<T> {


    void onSuccess(T responseMessage);

    void onFailure(String errorResponseMessage);


}
