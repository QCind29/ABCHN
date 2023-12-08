package com.food.lite.nckh.detection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.food.lite.nckh.detection.model.Vob;

import org.tensorflow.lite.examples.detection.R;

import java.util.ArrayList;

public class SenAdapter extends RecyclerView.Adapter<SenAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Vob> alVob;

    public SenAdapter(Context context, ArrayList<Vob> alVob) {
        this.context = context;
        this.alVob = alVob;
    }

    //Tao doi tuong de hien thi
    @NonNull
    @Override
    public SenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //gan vao card_view
        View view = inflater.inflate(R.layout.list_sen, parent, false);
        return new SenAdapter.ViewHolder(view);
    }

    //Chuyen du lieu vao ViewHolder, su kien thao tac tren tung item viet tai day
    @Override
    public void onBindViewHolder(@NonNull SenAdapter.ViewHolder holder, int position) {
        holder.CauTA.setText(alVob.get(position).getDatcauTA());
        holder.CauTV.setText(alVob.get(position).getDatcauTV());


    }

    //Truyen vo so luong co trong SQL
    @Override
    public int getItemCount() {
        return alVob.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        //ImageView imageView;
        public TextView CauTA, CauTV;
        public RelativeLayout cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //imageView = imageView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.layoutItem);
            CauTA = itemView.findViewById(R.id.tv_sTA);
            CauTV = itemView.findViewById(R.id.tv_sTV);
        }
    }
}
