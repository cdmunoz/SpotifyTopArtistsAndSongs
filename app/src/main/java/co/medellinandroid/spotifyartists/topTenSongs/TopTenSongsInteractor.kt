package co.medellinandroid.spotifyartists.topTenSongs

import co.medellinandroid.spotifyartists.MyApplication
import co.medellinandroid.spotifyartists.model.SpotifySongsResponse
import co.medellinandroid.spotifyartists.rest.ApiInterface
import co.medellinandroid.spotifyartists.utils.Constants
import io.reactivex.Observable
import javax.inject.Inject

class TopTenSongsInteractor {

  @Inject lateinit var apiInterface: ApiInterface

  init {
    MyApplication.application.appComponent.inject(this)
  }

  fun getTopTenSongsByArtist(artistId: String): Observable<SpotifySongsResponse> =
      apiInterface.getTopTenSongsByArtist(artistId, Constants.COUNTRY_MARKET)
}
