package co.medellinandroid.spotifyartists.model

import com.squareup.moshi.Json

class SpotifyArtistsResponse {

  @Json(name = "artists")
  val artists: SpotifyArtists? = null
}
