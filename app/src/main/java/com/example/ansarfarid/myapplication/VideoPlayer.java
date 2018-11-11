package com.example.ansarfarid.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class VideoPlayer extends YouTubeBaseActivity {

    private static final String TAG = "VideoPlayer";

    YouTubePlayerView youTubePlayerView;
    Button btnPlay;
    YouTubePlayer.OnInitializedListener onInitializedListener;
    TextView textView;
    ArrayList<String> list_names, list_path;
    int total;
    int position;

    MyDataBase myDataBase;
    ArrayList<String> fav_path, fav_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        final String path, name;
        Intent intent = getIntent();
        path = intent.getStringExtra("path");
        name = intent.getStringExtra("name");

        myDataBase = new MyDataBase(this);


        //These are imported in this activity only for the purpose of having a "next" button which when clicked will
        //play next video in listview now here stored as an arraylist.
        list_names = intent.getStringArrayListExtra("complete_name");
        list_path = intent.getStringArrayListExtra("complete_path");
        position = intent.getIntExtra("position", 0);
        total = intent.getIntExtra("total positions", 0);

        Toast.makeText(VideoPlayer.this, "position catched is : " + position, Toast.LENGTH_LONG ).show();

        textView = (TextView) findViewById(R.id.textView_video_name);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.YoutubeView);
        btnPlay = (Button) findViewById(R.id.button);

        initialize_it_now(name, path);

        /*btnPlay.setOnClickListener();

        */



    }




    public void initialize_it_now(final String name, final String path){
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, final YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick : Done Initializing.");

                load_my_video(youTubePlayer, name ,path);


            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick : Failed to initialize.");
            }
        };

        Log.d(TAG, "onClick : Initializing YouTube Player. ");
        youTubePlayerView.initialize(YoutubeConfig.getApiKey(), onInitializedListener);

    }




    public void load_my_video(final YouTubePlayer youTubePlayer, String name, String path){
        youTubePlayer.loadVideo(path);
        textView.setText(name);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
