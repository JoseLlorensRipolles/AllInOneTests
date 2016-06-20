package com.example.josemanuel.centralicedtests.reflexes.model;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.josemanuel.centralicedtests.R;
import com.example.josemanuel.centralicedtests.reflexes.Reflexes;

/**
 * Created by JoseManuel on 20/06/2016.
 */
public class ColorsAdapter extends RecyclerView.Adapter<ColorsAdapter.ColorsViewHolder> implements View.OnClickListener {
    Integer[] colors ;

    View.OnClickListener lister;
    Reflexes mainClass;

    public ColorsAdapter(Integer[] c, Reflexes mainClass){
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
        int intColor = colors[position];

        holder.bindColor(intColor);

    }

    @Override
    public int getItemCount() {
        return colors.length;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.lister= listener;
    }

    @Override
    public void onClick(View v) {
        if(lister!=null){
            lister.onClick(v);
            refillGrid();
            this.notifyDataSetChanged();
        }
    }
    private void refillGrid() {
        colors = new Integer[16];
        for(int i=0;i<16;i++){
            colors[i] = 0xff0000ff;
        }
        int i = (int)(Math.random()*16);
        colors[i] = 0xff00ff00;

        mainClass.setI(i);
    }

    public static class ColorsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;

        public ColorsViewHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linearLayaoutTableItem);
        }

        public void bindColor(int i){
            ColorDrawable colorDrawable = new ColorDrawable(i);
            linearLayout.setBackground(colorDrawable);
        }
    }
}
