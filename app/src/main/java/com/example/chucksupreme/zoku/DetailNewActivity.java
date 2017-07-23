package com.example.chucksupreme.zoku;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chucksupreme.zoku.adapters.BaseViewPagerAdapter;
import com.example.chucksupreme.zoku.fragment.BioFragment;
import com.example.chucksupreme.zoku.fragment.DiscoFragment;

import java.util.ArrayList;

public class DetailNewActivity extends AppCompatActivity {

    private ArrayList<Pair<String,Fragment>> list = new ArrayList<Pair<String,Fragment>>();

    private static ViewPager viewPager;
    private TabLayout tabLayout;
    private TextView tv;
    private ImageView artpic;
    private TextView tvinfo;
    private BioFragment bio;
    private TextView tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_new);
        viewPager = (ViewPager)findViewById(R.id.activity_detail_new_viewpager);
        tabLayout = (TabLayout)findViewById(R.id.activity_advance_view_pager_tablelayout);
        list.add(new Pair<String, Fragment>("BIO", new BioFragment()));
        list.add(new Pair<String, Fragment>("DISCOGRAPHY", new DiscoFragment()));
        BaseViewPagerAdapter adapter = new BaseViewPagerAdapter(this.getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        final Bundle extras = getIntent().getExtras();
        tv = ((TextView) findViewById(R.id.content_name));
        tv.setText(extras.getString("text"));


        int imageInt = getIntent().getIntExtra("picture", R.drawable.big);
        //String artInfo = getIntent().getStringExtra("info");
        artpic = ((ImageView) findViewById(R.id.imagefull));
        artpic.setImageResource(imageInt);
    }
}
