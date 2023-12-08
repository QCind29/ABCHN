package com.food.lite.nckh.detection.adapter;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.food.lite.nckh.detection.model.Vob;

import org.tensorflow.lite.examples.detection.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> implements Filterable {
    public static MediaPlayer mediaPlayer = new MediaPlayer();
    static String URL;


    private Context context;
    private ArrayList<Vob> alVob;
    private ArrayList<Vob> allVob;

    public TvAdapter(Context context, ArrayList<Vob> alVob) {
        this.context = context;
        this.alVob = alVob;
        this.allVob = new ArrayList<>(alVob);
    }



    @NonNull
    @Override
    public TvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        //gan vao card_view
        View view = inflater.inflate(R.layout.list_tv, parent, false);
        return new TvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.ViewHolder holder, int position) {
        holder.name.setText(alVob.get(position).getTendoituongTA());
        holder.ten.setText(alVob.get(position).getTendoituongTV());
        holder.url.setText(alVob.get(position).getAudioEN());
        holder.urll.setText(alVob.get(position).getAudioVN());



    }


    @Override
    public int getItemCount() {
        return alVob.size();
    }

    @Override
    public Filter getFilter() {
        return alVobFilter;
    }
    private Filter alVobFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Vob> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length()==0){
                filteredList.addAll(allVob);
            }else{
//                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Vob item : allVob) {
                    if (item.getTendoituongTA().toLowerCase().contains(constraint.toString().toLowerCase()) || item.getTendoituongTV().toLowerCase().contains(constraint.toString().toLowerCase()) )  {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return  results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            alVob.clear();
            alVob.addAll((Collection<? extends Vob>) results.values);
            notifyDataSetChanged();

        }
    };

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name, urll;
        public TextView ten;
        public  TextView url;
        public RelativeLayout cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            cardView = itemView.findViewById(R.id.layoutItem);
            name = itemView.findViewById(R.id.tv_TA);
            ten = itemView.findViewById(R.id.tv_TV);
            url = itemView.findViewById(R.id.tv_url);
            urll = itemView.findViewById(R.id.tv_urll);

            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playAuEN();
                }
            });
            ten.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playAuVN();
                }
            });


        }

        public void playAuEN() {
            URL = "";
            URL = String.valueOf(url.getText());
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();

            } else {
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(URL);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.prepareAsync();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        public void playAuVN() {
            URL = "";
            URL = String.valueOf(urll.getText());
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();

            } else {
                mediaPlayer = new MediaPlayer();
                try {
                    mediaPlayer.setDataSource(URL);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.prepareAsync();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
