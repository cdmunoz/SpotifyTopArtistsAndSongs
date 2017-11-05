package co.medellinandroid.spotifyartists.model

import com.squareup.moshi.Json
import java.util.ArrayList

class SpotifyAlbum {

  @Json(name = "id")
  var id: String? = null
  @Json(name = "name")
  var name: String? = null
  @Json(name = "images")
  var images: List<SpotifyAlbumImage> = ArrayList()
}
