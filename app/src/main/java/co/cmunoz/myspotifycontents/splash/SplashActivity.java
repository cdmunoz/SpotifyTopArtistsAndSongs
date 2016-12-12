package co.cmunoz.myspotifycontents.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import co.cmunoz.myspotifycontents.topTenArtists.TopTenArtistsActivity;

/**
 * Splash Activity
 *
 * User: cmunoz
 * Date: 12/7/16
 * Time: 11:01 AM
 */

public class SplashActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = new Intent(this, TopTenArtistsActivity.class);
    startActivity(intent);
    finish();
  }
}
