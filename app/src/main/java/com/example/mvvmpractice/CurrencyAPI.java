package com.example.mvvmpractice;



import io.reactivex.Observable;
import retrofit2.http.GET;

public interface CurrencyAPI {
    String BASE_URL = "https://www.cbr-xml-daily.ru/daily_json.js/";

    @GET("/daily_json.js")
    Observable<PriceData> getPrice();

}
