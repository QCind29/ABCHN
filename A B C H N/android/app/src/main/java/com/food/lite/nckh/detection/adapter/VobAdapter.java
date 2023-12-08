package com.food.lite.nckh.detection.adapter;

import static com.food.lite.nckh.detection.adapter.VobAdapter.ViewHolder.AuVN;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.food.lite.nckh.detection.model.Vob;
import com.food.lite.nckh.detection.sqlite.sqlVob;

import org.tensorflow.lite.examples.detection.R;

import java.io.IOException;
import java.util.ArrayList;

public class VobAdapter extends RecyclerView.Adapter<VobAdapter.ViewHolder>{
    public static MediaPlayer mediaPlayer = new MediaPlayer();
    public  static String url;
    public  static String urll;




    private Context context;
    private ArrayList<Vob> alVob;

    public VobAdapter(Context context, ArrayList<Vob> alVob) {
        this.context = context;
        this.alVob = alVob;
    }

    //Tao doi tuong de hien thi
    @NonNull
    @Override
    public VobAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //gan vao card_view
        View view = inflater.inflate(R.layout.list_vob, parent, false);
        return new VobAdapter.ViewHolder(view);
    }

    //Chuyen du lieu vao ViewHolder, su kien thao tac tren tung item viet tai day
    @Override
    public void onBindViewHolder(@NonNull VobAdapter.ViewHolder holder, int position) {
        holder.TendtTA.setText(alVob.get(position).getTendoituongTA());
        holder.TendtTV.setText(alVob.get(position).getTendoituongTV());
//        holder.AuVN.setText(alVob.get(position).getAudioVN());
        holder.AuEN.setText(String.valueOf(alVob.get(position).getIdVob()));

    }


    @Override
    public int getItemCount() {
        return alVob.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        //ImageView imageView;
        public static TextView TendtTA, TendtTV, AuEN, AuVN ;

        public RelativeLayout cardView;
        public sqlVob sqlVob;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //imageView = imageView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.layoutItem);
            TendtTA = itemView.findViewById(R.id.tv_TA);
            TendtTV = itemView.findViewById(R.id.tv_TV);
            AuEN = itemView.findViewById(R.id.au_EN);
            AuVN = itemView.findViewById(R.id.au_VN);

//            AuVN.setText("https://dbhai60.github.io/Audio/Bowl.mp3");


            TendtTA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playAu();
                }
        });
    }
    public static void playAu() {
        urll = "";
        urll =String.valueOf(AuVN.getText());
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();

        } else {
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(urll);
                mediaPlayer.prepare();
                mediaPlayer.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }}}
    }


