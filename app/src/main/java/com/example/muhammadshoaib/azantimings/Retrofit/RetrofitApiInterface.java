package com.example.muhammadshoaib.azantimings.Retrofit;

import com.example.muhammadshoaib.azantimings.POJOClasses.AzanTimeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiInterface {


    //this abstract method will return result in "Call" return type
    @GET("getMontlyPrayerTime/38/2019-04-23/B")
    Call<List<AzanTimeModel>> getAzanTimings();
}
