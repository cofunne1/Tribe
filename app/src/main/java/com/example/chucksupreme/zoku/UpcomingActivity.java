package com.example.chucksupreme.zoku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.chucksupreme.zoku.adapters.GridAdapterUp;

public class UpcomingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
        GridView gridView = (GridView) findViewById(R.id.gridview2);
        gridView.setAdapter(new GridAdapterUp(this));
    }
}
