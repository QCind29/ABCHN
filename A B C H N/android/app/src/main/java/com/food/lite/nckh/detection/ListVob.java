package com.food.lite.nckh.detection;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.food.lite.nckh.detection.adapter.VobAdapter;
import com.food.lite.nckh.detection.sqlite.sqlVob;

import org.tensorflow.lite.examples.detection.R;

public class ListVob extends AppCompatActivity {
    private RecyclerView recyclerView;
    private VobAdapter vobAdapter;
    sqlVob sqlvob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_list_vob);


        //init View
        recyclerView = (RecyclerView) findViewById(R.id.idRecycle);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        sqlvob = new sqlVob(this);

        vobAdapter = new VobAdapter(this, sqlvob.getAll());
        recyclerView.setAdapter(vobAdapter);
    }
}
