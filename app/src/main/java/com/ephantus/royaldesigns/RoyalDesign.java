package com.ephantus.royaldesigns;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class RoyalDesign extends AppCompatActivity {
    public static final String TAG = RoyalDesign.class.getSimpleName();
    @BindView(R.id.listView) ListView mListView;
    private TextView mLocationTextView;
//    private ListView mListView =(ListView) findViewById(R.id.listView);
    private String[] royal_desigs = new String[]{"T-shit T-shirt", "Jeans Jeans",
            "Jacket Jacket", "Dress Dress", "Boxer boxer"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_royal_design);

        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, royal_desigs);
        mListView.setAdapter(adapter);

        getFashions();
    }

    public void getFashions(){
        FashionService.findFashion(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData= response.body().string();
                    Log.v("ephadesign", jsonData);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
}

