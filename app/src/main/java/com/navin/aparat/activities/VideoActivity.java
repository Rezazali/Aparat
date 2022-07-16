package com.navin.aparat.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;
import com.navin.aparat.R;
import com.navin.aparat.database.AppDatabase;
import com.navin.aparat.databinding.ActivityVideoBinding;
import com.navin.aparat.models.Video;

public class VideoActivity extends AppCompatActivity {

    ActivityVideoBinding binding;

    ExoPlayer player;

    Bundle bundle;
    Video video;

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appDatabase = AppDatabase.getInstance(this);

        bundle = getIntent().getExtras();
        video = bundle.getParcelable("object");

        player=  new ExoPlayer.Builder(this).build();

        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(video.getLink()));
        player.setMediaItem(mediaItem);

        player.prepare();
        player.play();
        binding.videoView.setPlayer(player);


        if(appDatabase.idao().isExists(Integer.parseInt(video.getId()))) {
            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
        }else {
            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
        }


        binding.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(appDatabase.idao().isExists(Integer.parseInt(video.getId()))) {

                    appDatabase.idao().deleteVideo(Integer.parseInt(video.getId()));
                    binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                }else {

                    long result = appDatabase.idao().insert(video);
                    binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);

                }



            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(player!=null){
            player.stop();
        }

    }
}