package com.sandeep.github01.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    private static Retrofit wooRetrofit = null;
    public static String baseUrl =  "GIVE BASE URL HERE";
    public static final OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(2,TimeUnit.MINUTES).writeTimeout(2,TimeUnit.MINUTES).connectTimeout(2,TimeUnit.MINUTES).build();
    public static Retrofit getClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).readTimeout(2,TimeUnit.MINUTES).writeTimeout(2,TimeUnit.MINUTES).connectTimeout(2,TimeUnit.MINUTES).build();
        if (retrofit == null) {
             retrofit = new Retrofit.Builder()
                    .baseUrl(HttpUrl.get(baseUrl))
                    .addConverterFactory(GsonConverterFactory.create())
                     .client(okHttpClient)
                    .build();
        }

        return retrofit;
    }


}
