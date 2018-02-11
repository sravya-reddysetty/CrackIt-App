package com.example.sys1.customissue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by sys1 on 8/5/2017.
 */

public class Mycustom  extends BaseAdapter{
    Integer[] images;
    String[] br;
    MainActivity ma;
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater if=(LayoutInflater.from(ma));
        View v=if.inflate(R.l)
        return v;
    }
}
