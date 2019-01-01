package com.reag.application;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.app.ListFragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.reag.application.ArrayOfImage.getArray;


public class BlankFragmentNext extends ListFragment {

    final String ATTRIBUTE_NAME_IMAGE = "image";






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_blank_fragment_next, container, false);

       ArrayList<Map<String, Object>> data = new ArrayList<>(getArray().length);
        Map<String, Object> m;
        for (int i = 0; i < getArray().length; i++) {
            m = new HashMap<String, Object>();
            m.put(ATTRIBUTE_NAME_IMAGE, getArray()[i]);
            data.add(m);
        }
        String[] from = {ATTRIBUTE_NAME_IMAGE};
        int[] to = {R.id.imageViewItem};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),data, R.layout.simple_list_item, from, to);
        setListAdapter(simpleAdapter);
        return view;
    }

}
