package com.example.haoliu.myyoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;

import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity {
    // Explain.
    private static final String TAG = "MainActivity";


    YouTubePlayerView mYouTubePlayerView;
    Button ButtonPlay;
    YouTubePlayer.OnInitializedListener mOnInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:Starting.");
        ButtonPlay = (Button) findViewById(R.id.ButtonPlay);
        mYouTubePlayerView = (YouTubePlayerView) findViewById(R.id.YouTubePlayer);

        mOnInitializedListener = new OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onInitializationSuccess: Done Initializing");
//                List<String> videoList = new ArrayList<>();
//                videoList.add("");
//                videoList.add("");
//                youTubePlayer.loadVideo("");
                youTubePlayer.loadPlaylist("PL4C2OaC1jQqR3ICDBf4j1dH1Fk4uIo-Lx");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationSuccess: Fail to Initialize");

            }
        };
        ButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Initializing YouTube Player.");
                mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(), mOnInitializedListener);
            }
        });
    }
}
