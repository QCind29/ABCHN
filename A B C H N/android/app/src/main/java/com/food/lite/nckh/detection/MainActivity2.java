package com.food.lite.nckh.detection;

import static com.food.lite.nckh.detection.adapter.VobAdapter.ViewHolder.playAu;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.food.lite.nckh.detection.adapter.VobAdapter;
import com.food.lite.nckh.detection.sqlite.sqlVob;

import org.tensorflow.lite.examples.detection.R;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    private VobAdapter vobAdapter;
    sqlVob sqlvob;

    protected Button buttonDetect;
    protected Button cameraButton;
    protected Button buttonListView;
    protected Button test;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sqlvob = new sqlVob(this);

        vobAdapter = new VobAdapter(this, sqlvob.getVob());



        setContentView(R.layout.activity_main2);

        buttonDetect = findViewById(R.id.buttonDetect);
        buttonDetect.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, DetectGallery.class);//Thu vien
            startActivity(intent);
        });




        cameraButton = findViewById(R.id.cameraButton);
        cameraButton.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, DetectorActivity.class)));//Realtime

        buttonListView = findViewById(R.id.buttonListView);
        buttonListView.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, ListTV.class)));
//

    }



}


