package com.example.chucksupreme.zoku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.chucksupreme.zoku.adapters.GridAdapterBrowse;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new GridAdapterBrowse(this));
    }
}
