package com.example.chucksupreme.zoku.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chucksupreme.zoku.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.chucksupreme.zoku.R.id.picture;

/**
 * Created by chucksupreme on 7/12/17.
 */

public final class GridAdapterFav extends BaseAdapter {
    private final List<Item> mItems = new ArrayList<Item>();
    private final LayoutInflater mInflater;
    private final Context mContext;

    public GridAdapterFav(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.currensy), R.drawable.currensy,  context.getString(R.string.currensyInfo)));
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.eminem),      R.drawable.eminem,     context.getString(R.string.eminemInfo)));
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.gambino),     R.drawable.gambino,    context.getString(R.string.gambinoInfo)));
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.gucci),      R.drawable.gucci,   context.getString(R.string.gucciInfo)));
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.jay),      R.drawable.jay,   context.getString(R.string.jayInfo)));
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.wiz),     R.drawable.khalifa,    context.getString(R.string.wizInfo)));
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.rocky),      R.drawable.rocky,   context.getString(R.string.rockyInfo)));
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.kendrick),      R.drawable.lamar,    context.getString(R.string.kendrickInfo)));
        mItems.add(new GridAdapterFav.Item(context.getString(R.string.mosdef),      R.drawable.mosdef,     context.getString(R.string.mosdefInfo)));
    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Item getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mItems.get(i).drawableId;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        ImageView pic;
        TextView name;

        if (v == null) {
            v = mInflater.inflate(R.layout.grid_layout_fav, viewGroup, false);
            v.setTag(picture, v.findViewById(picture));
            v.setTag(R.id.text, v.findViewById(R.id.text));
        }


        pic = (ImageView) v.getTag(picture);
        name = (TextView) v.getTag(R.id.text);

        Item item = getItem(i);

        pic.setImageResource(item.drawableId);
        name.setText(item.name);

        return v;


    }

    private static class Item {
        public final String name;
        public final int drawableId;
        public final String info;

        Item(String name, int drawableId, String info) {
            this.name = name;
            this.drawableId = drawableId;
            this.info = info;
        }

        public String getName()
        {return name; }

        public String getItemInfo()
        {return info; }
    }
}
