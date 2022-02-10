package com.sandeep.github01.retrofit;

import android.content.Context;
import java.io.File;
import java.util.concurrent.TimeUnit;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class BackgroundTaskUtility {
    static int retryCount = 0;


//    public static GETCitiesStatesResponse callCitiesAPI(Context context) throws IOException {
//        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<GETCitiesStatesResponse> request = apiInterface.getCitiesResponse(Constants.APPLICATION_JSON, CommonUtil.getAPIKey(context));
//        Response<GETCitiesStatesResponse> response = request.execute();
//        if (response.code() == 403 && callRefreshTokenApi(context, new RefreshTokenRequest(CommonUtil.readPrefString(context, Constants.REFRESH_TOKEN))) && retryCount < 2) {
//            retryCount++;
//            return callCitiesAPI(context);
//        }else retryCount = 0;
//        return response.body();
//    }



    public static okhttp3.Response uploadImages(Context context, File file, String presignedUrl) {

        HttpUrl.Builder httpUrlBuilder = HttpUrl.parse(presignedUrl).newBuilder();

        try {

            HttpUrl httpUrl = httpUrlBuilder.build();
            okhttp3.Response response = null;
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .build();

            RequestBody requestBody = RequestBody.create(file, MediaType.parse("*/*"));

            Request request = new Request.Builder()
                    .url(httpUrl)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("API_KEY", "getAPIKey(context)") //function for api key
                    .put(requestBody)
                    .build();
            response = client.newCall(request).execute();
            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
