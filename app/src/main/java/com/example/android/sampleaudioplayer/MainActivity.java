package com.example.android.sampleaudioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    Button playButton;
    Button pauseButton;
    Button fFwdButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.play_button);
        pauseButton = findViewById(R.id.pause_button);
        fFwdButton = findViewById(R.id.ff_button);
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.rtdropbabydrop);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mediaPlayer.pause();
            }
        });

        fFwdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo( 10000);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();

        mediaPlayer.release();
        mediaPlayer = null;
    }

}
