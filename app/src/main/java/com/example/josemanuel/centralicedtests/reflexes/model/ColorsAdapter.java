package com.example.josemanuel.centralicedtests.reflexes.model;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.josemanuel.centralicedtests.R;
import com.example.josemanuel.centralicedtests.reflexes.Reflexes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JoseManuel on 20/06/2016.
 */
public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorsViewHolder> implements View.OnClickListener {
    List<ColorDrawable> colors ;
    int i;

    View.OnClickListener lister;
    Reflexes mainClass;

    public ColorsAdapter(List<ColorDrawable> c, Reflexes mainClass){
        colors=c;
        this.mainClass = mainClass;
    }

    @Override
    public ColorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_color_item,parent,false);

        itemView.setOnClickListener(this);

        ColorsViewHolder cvh = new ColorsViewHolder(itemView);

        return cvh;
    }

    @Override
    public void onBindViewHolder(ColorsViewHolder holder, int position) {
        ColorDrawable colorDrawable = colors.get(position);

        holder.bindColor(colorDrawable);

    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.lister= listener;
    }

    @Override
    public void onClick(View v) {
        if(lister!=null){
            lister.onClick(v);
        }
    }

    /*public void setColors(List<Integer>c){
        this.colors=c;
    }*/

    public void printLog() {
        Log.i("Colors in adapter",colors.toString());
    }

    public static class ColorsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;

        public ColorsViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayaoutTableItem);
        }

        public void bindColor(ColorDrawable colorDrawable){
            linearLayout.setBackground(colorDrawable);
        }
    }
}
