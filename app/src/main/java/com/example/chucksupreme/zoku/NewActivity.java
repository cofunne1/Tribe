package com.example.chucksupreme.zoku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.chucksupreme.zoku.adapters.GridAdapterNew;

public class NewActivity extends AppCompatActivity {

    private Animation scaleAnim;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new GridAdapterNew(this));

        initialAnimation();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NewActivity.this, DetailNewActivity.class);

                //Bundle tags for the three listed information on each artist
                intent.putExtra("text", GridAdapterNew.mItems.get(i).name);
                intent.putExtra("picture", GridAdapterNew.mItems.get(i).drawableId);
                intent.putExtra("info", GridAdapterNew.mItems.get(i).info);

                //initialize animation on image click
                view.startAnimation(scaleAnim);

                startActivity(intent);
            }
        });
    }

    private void initialAnimation() {
        scaleAnim = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
    }
}
