package co.medellinandroid.spotifyartists.model

import com.squareup.moshi.Json
import java.util.ArrayList

class SpotifySongsResponse {

  @Json(name = "tracks")
  var tracks: List<SpotifyTrack> = ArrayList()
}
