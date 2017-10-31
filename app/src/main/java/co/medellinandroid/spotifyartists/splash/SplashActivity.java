package co.medellinandroid.spotifyartists.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsActivity;

public class SplashActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = new Intent(this, TopTenArtistsActivity.class);
    startActivity(intent);
    finish();
  }
}
