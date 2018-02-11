package com.example.sys1.sravya;

import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sys1 on 10/3/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private ArrayList<DatabaseObject> dataset;
    Boolean check=false;
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,loc,phone;
        RelativeLayout expandable;
        
    }
}
