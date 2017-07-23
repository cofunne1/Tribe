package com.example.chucksupreme.zoku.fragment;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.chucksupreme.zoku.R;


public class DiscoFragment extends ListFragment {


    public DiscoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_disco, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] values = new String[] { "Ready To Die", "The State vs. Radric Davis", "J.L.R",
                "4:44", "28 Grams", "To Pimp A Butterfly", "Illmatic", "Issa",
                "The Low End Theory", "Purple Rain" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                 R.layout.disco_list, R.id.Itemname, values);
        setListAdapter(adapter);
    }
}
