package com.example.josemanuel.centralicedtests.reflexes;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.josemanuel.centralicedtests.R;
import com.example.josemanuel.centralicedtests.reflexes.model.ColorsAdapter;

import java.util.ArrayList;
import java.util.List;

public class Reflexes extends AppCompatActivity {

    List<ColorDrawable> colors;
    TextView correctTextView;
    RecyclerView mainRecyclerView;
    ColorsAdapter adapter;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflexes);
        initGrid();

        mainRecyclerView = (RecyclerView)findViewById(R.id.reflexesRecyclerViewMain);
        correctTextView = (TextView)findViewById(R.id.textViewCorrect);

        if(mainRecyclerView == null){
            Log.e("asdasd","ASDLKNAÑLSKDN");
            return;
        }

        adapter = new ColorsAdapter(colors,this);
        mainRecyclerView.setLayoutManager(new GridLayoutManager(this,4));

        mainRecyclerView.setAdapter(adapter);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int positionPulsed = mainRecyclerView.getChildPosition(v);
                if(positionPulsed==i){
                    correctTextView.setText("Correct!");
                    fillGrid();
                    /*Log.i("Colors in reflexes","ANTES"+colors.toString());
                    adapter.printLog();
                    fillGrid();
                    Log.i("Colors in reflexes",colors.toString());
                    adapter.printLog();*/
                    //adapter.setColors(colors);
                }else{
                    correctTextView.setText("False!");
                }

                adapter.notifyDataSetChanged();
            }

        };

        adapter.setOnClickListener(listener);
    }


    private void initGrid(){
        colors = new ArrayList<>(16);
        for(int i=0;i<16;i++){
            colors.add(new ColorDrawable(0xff0000ff));
        }
        i = (int)(Math.random()*16);
        colors.set(i,new ColorDrawable(0xff00ff00));
    }

    private void fillGrid() {
        for(int i=0;i<16;i++){
            colors.get(i).setColor(0xff0000ff);
            //colors.add(new ColorDrawable(0xff0000ff));
        }
        i = (int)(Math.random()*16);
        colors.get(i).setColor(0xff00ff00);

    }



}
