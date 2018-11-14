package com.ephantus.royaldesigns;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FashionService {
    public static void findFashion(Callback callback){
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.FASHION_BASE_URL).newBuilder();
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .addHeader("X-APP-ID",Constants.FASHION_APP_ID)
                .addHeader( "X-API-KEY" ,Constants.FASHION_API_KEY)
                .url(url)
                .build();

        Call call= client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Fashion> processResults(Response response){
        ArrayList<Fashion> fashions= new ArrayList<>();

        try {
            String jsonData= response.body().string();
            if (response.isSuccessful()){
                JSONObject fashionJSON = new JSONObject(jsonData);
                JSONArray outputJSON = fashionJSON.getJSONArray("outputs");
                JSONObject labels= outputJSON.getJSONObject("labels");
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
}
