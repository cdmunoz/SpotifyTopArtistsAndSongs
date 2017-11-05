package co.medellinandroid.spotifyartists.model

import com.squareup.moshi.Json
import java.util.ArrayList

class SpotifyArtists {

  @Json(name = "href")
  var href: String? = null
  @Json(name = "items")
  var items: List<SpotifyArtistsItems> = ArrayList()
  @Json(name = "limit")
  var limit: Int = 0
  @Json(name = "next")
  var next: String? = null
  @Json(name = "offset")
  var offset: Int = 0
  @Json(name = "previous")
  var previous: String? = null
  @Json(name = "total")
  var total: Int = 0
}
