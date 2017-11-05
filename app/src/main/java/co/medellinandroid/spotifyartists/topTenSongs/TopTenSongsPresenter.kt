package co.medellinandroid.spotifyartists.topTenSongs

import co.medellinandroid.spotifyartists.model.SpotifySongsResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TopTenSongsPresenter @Inject constructor() : TopTenSongsContract.Presenter {

  private var view: TopTenSongsContract.View? = null
  private val topTenSongsInteractor: TopTenSongsInteractor = TopTenSongsInteractor()
  private lateinit var disposableObserver: DisposableObserver<SpotifySongsResponse>

  override fun attachView(view: TopTenSongsContract.View) {
    this.view = view
  }

  override fun getTopTenSongs(artistId: String) {
    view?.showProgress()
    disposableObserver = object : DisposableObserver<SpotifySongsResponse>() {
      override fun onNext(spotifySongsResponse: SpotifySongsResponse) {
        view?.hideProgress()
        view?.showSongs(spotifySongsResponse.tracks)
      }

      override fun onError(e: Throwable) {
        view?.hideProgress()
        view?.showError(e.message!!)
      }

      override fun onComplete() {
        view?.hideProgress()
      }
    }
    topTenSongsInteractor.getTopTenSongsByArtist(artistId)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(disposableObserver)
  }

  override fun destroy() {
    view = null
    if (!disposableObserver.isDisposed) {
      disposableObserver.dispose()
    }
  }
}
