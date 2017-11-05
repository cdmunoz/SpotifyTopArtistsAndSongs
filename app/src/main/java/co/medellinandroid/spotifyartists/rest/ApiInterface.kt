package co.medellinandroid.spotifyartists.rest

import co.medellinandroid.spotifyartists.model.SpotifyArtistsResponse
import co.medellinandroid.spotifyartists.model.SpotifySongsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

  @GET("search")
  fun getTopTenArtists(
      @Query(value = "q", encoded = true) query: String, @Query("type") type: String,
      @Query("market") market: String, @Query(
          "limit") limit: Int): Observable<SpotifyArtistsResponse>

  @GET("artists/{id}/top-tracks")
  fun getTopTenSongsByArtist(
      @Path("id") artistId: String, @Query(
          "country") country: String): Observable<SpotifySongsResponse>
}
