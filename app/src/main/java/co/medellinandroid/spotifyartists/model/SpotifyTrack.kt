package co.medellinandroid.spotifyartists.model

import com.squareup.moshi.Json

class SpotifyTrack {

  @Json(name = "id")
  var id: String? = null
  @Json(name = "name")
  var name: String? = null
  @Json(name = "duration_ms")
  var duration: Int = 0
  @Json(name = "album")
  var album: SpotifyAlbum? = null

  init {
    this.album = SpotifyAlbum()
  }
}
