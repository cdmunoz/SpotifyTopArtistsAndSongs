package co.medellinandroid.spotifyartists.model

import com.squareup.moshi.Json

class SpotifyAlbumImage {
  @Json(name = "height")
  var height: Int = 0
  @Json(name = "width")
  var width: Int = 0
  @Json(name = "url")
  var url: String? = null
}
