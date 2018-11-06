package com.ephantus.royaldesigns;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RoyalDesign extends AppCompatActivity {
    @BindView(R.id.listView) ListView mListView;
    private TextView mLocationTextView;
//    private ListView mListView =(ListView) findViewById(R.id.listView);
    private String[] royal_desigs = new String[]{"Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Lardo", "Portland City Grill"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_royal_design);

        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, royal_desigs);
        mListView.setAdapter(adapter);

    }

}

