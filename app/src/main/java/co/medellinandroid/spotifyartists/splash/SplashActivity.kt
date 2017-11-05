package co.medellinandroid.spotifyartists.splash

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsActivity

class SplashActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val intent = Intent(this, TopTenArtistsActivity::class.java)
    startActivity(intent)
    finish()
  }
}
