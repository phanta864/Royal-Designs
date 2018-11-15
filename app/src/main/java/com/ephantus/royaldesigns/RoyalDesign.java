package com.ephantus.royaldesigns;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class RoyalDesign extends AppCompatActivity {
    public static final String TAG = RoyalDesign.class.getSimpleName();
    public ArrayList<Fashion> mFashions= new ArrayList<>();

//    @BindView(R.id.listView) ListView mListView;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    private FashionListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_royal_design);

        ButterKnife.bind(this);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, royal_desigs);
//        mListView.setAdapter(adapter);

        getFashions();
    }

    public void getFashions(){
        final FashionService fashionService= new FashionService();
        fashionService.findFashion(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("HelloThea",e.getMessage());
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mFashions = fashionService.processResults(response);

                RoyalDesign.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter= new FashionListAdapter(getApplicationContext(), mFashions);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(RoyalDesign.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}

