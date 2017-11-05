package co.medellinandroid.spotifyartists.topTenArtists

import co.medellinandroid.spotifyartists.model.SpotifyArtistsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopTenArtistsPresenter @Inject constructor() : TopTenArtistsContract.Presenter {

  internal var view: TopTenArtistsContract.View? = null
  private val topTenArtistsInteractor: TopTenArtistsInteractor = TopTenArtistsInteractor()
  private lateinit var disposableObserver: DisposableObserver<SpotifyArtistsResponse>

  override fun attachView(view: TopTenArtistsContract.View) {
    this.view = view
  }

  override fun getTopTenArtists() {
    view?.showProgress()
    disposableObserver = object : DisposableObserver<SpotifyArtistsResponse>() {
      override fun onNext(spotifyArtistsResponse: SpotifyArtistsResponse) {
        view?.hideProgress()
        view?.showList(spotifyArtistsResponse.artists!!.items)
      }

      override fun onError(e: Throwable) {
        view?.hideProgress()
        view?.showError(e.message!!)
      }

      override fun onComplete() {
        view?.hideProgress()
      }
    }

    topTenArtistsInteractor.topTenArtists
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(disposableObserver)
  }

  override fun onDestroy() {
    view = null
    if (!disposableObserver.isDisposed) {
      disposableObserver.dispose()
    }
  }
}
