package co.medellinandroid.spotifyartists.model

import com.squareup.moshi.Json
import java.util.ArrayList

class SpotifyArtistsItems {

  @Json(name = "id")
  var id: String? = null
  @Json(name = "name")
  var name: String? = null
  @Json(name = "uri")
  var uri: String? = null
  @Json(name = "images")
  var images: List<SpotifyArtistImage> = ArrayList()

  class Builder {
    private val spotifyArtist = SpotifyArtistsItems()

    fun withName(name: String): Builder {
      spotifyArtist.name = name
      return this
    }

    fun build(): SpotifyArtistsItems = spotifyArtist
  }
}
