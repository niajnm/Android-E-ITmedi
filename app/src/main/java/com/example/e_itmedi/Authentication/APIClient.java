package com.example.e_itmedi.Authentication;
import com.example.e_itmedi.Authentication.AccessTokenServiceInterface;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class APIClient {

    private static Retrofit retrofit = null;

    static Retrofit getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://sandbox.emdexapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
             return retrofit;
    }


     public  static AccessTokenServiceInterface ATservice(){

         AccessTokenServiceInterface apiInterface = getClient().create(AccessTokenServiceInterface.class);

            return apiInterface;
     }

}