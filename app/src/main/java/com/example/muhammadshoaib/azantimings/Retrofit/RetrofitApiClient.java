package com.example.muhammadshoaib.azantimings.Retrofit;

import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {

    //Declaring Base url of rest Api
    public static final String BASE_URL = "http://masjidi.co.uk/api/";

    //Delaring Retrofit
    public static Retrofit retrofit = null;

    //this method will return instance of retrofit
    public static Retrofit getApiClient() {

        //this condition will check if retrofit is equal to null
        if (retrofit == null) {

            //if it is null it will build retrofit
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        return retrofit;
    }

}