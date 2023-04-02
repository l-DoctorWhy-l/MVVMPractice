package com.example.mvvmpractice;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrencyRepository {

    public static CurrencyAPI getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(CurrencyAPI.BASE_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(CurrencyAPI.class);
    }

    public static Observable<PriceData> getPriceData(){
        return getRetrofit().getPrice();
    }
}
