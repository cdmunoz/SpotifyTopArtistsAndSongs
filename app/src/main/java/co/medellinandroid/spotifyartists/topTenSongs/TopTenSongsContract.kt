package co.medellinandroid.spotifyartists.topTenSongs

import co.medellinandroid.spotifyartists.model.SpotifyTrack

interface TopTenSongsContract {

  interface View {
    fun showProgress()

    fun hideProgress()

    fun showError(message: String)

    fun showSongs(tracks: List<SpotifyTrack>)
  }

  interface Presenter {
    fun attachView(view: View)

    fun getTopTenSongs(artistId: String)

    fun destroy()
  }
}
