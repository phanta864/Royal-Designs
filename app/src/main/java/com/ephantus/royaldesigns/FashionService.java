package com.ephantus.royaldesigns;

import android.util.Log;

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
        urlBuilder.addQueryParameter("client_id", Constants.FASHION_API_KEY)
                .addQueryParameter("query", "clothing");
        String url = urlBuilder.build().toString();
        Log.d("URL", url);

        Request request= new Request.Builder()
                .addHeader("Authorization", "Client-ID " + Constants.FASHION_API_KEY)
                .url(url)
                .build();
        String lastRequest= request.toString();
        Log.d("WesAme",lastRequest);

        Call call= client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Fashion> processResults(Response response){
        ArrayList<Fashion> fashions= new ArrayList<>();

        try {
            String jsonData= response.body().string();
            if (response.isSuccessful()){
                Log.i("ephaDesignsHello",jsonData);
                JSONObject allDataJSON = new JSONObject(jsonData);
                JSONArray fashionJSON = allDataJSON.getJSONArray("results");
                for (int i=0; i<fashionJSON.length(); i++){
                    JSONObject imageJSON = fashionJSON.getJSONObject(i);
                    String name = imageJSON.getString("description");
                    JSONObject imageUrlJSON= imageJSON.getJSONObject("urls");
                    String image= imageUrlJSON.getString("small");
                    JSONObject userJSON = fashionJSON.getJSONObject(i);
                    JSONObject userNAMEJSON =  userJSON.getJSONObject("user");
                    String username = userNAMEJSON.getString("username");
                    String location = userNAMEJSON.getString("location");


                    Fashion fashion= new Fashion(image, name, username, location);
                    fashions.add(fashion);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return fashions;
    }
}
