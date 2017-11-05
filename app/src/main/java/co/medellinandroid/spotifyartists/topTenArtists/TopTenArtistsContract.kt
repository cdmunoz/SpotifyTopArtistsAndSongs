package co.medellinandroid.spotifyartists.topTenArtists

import co.medellinandroid.spotifyartists.model.SpotifyArtistsItems

interface TopTenArtistsContract {

  interface View {
    fun showProgress()
    fun hideProgress()
    fun showError(message: String)
    fun showList(topTenArtists: List<SpotifyArtistsItems>)
  }

  interface Presenter {
    fun attachView(view: View)
    fun getTopTenArtists()
    fun onDestroy()
  }
}
