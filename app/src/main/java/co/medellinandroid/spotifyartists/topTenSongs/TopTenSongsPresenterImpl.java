package co.medellinandroid.spotifyartists.topTenSongs;

import co.medellinandroid.spotifyartists.model.SpotifySongsResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class TopTenSongsPresenterImpl implements TopTenSongsPresenter {

  private TopTenSongsView view;
  private TopTenSongsInteractor topTenSongsInteractor;
  private DisposableObserver<SpotifySongsResponse> disposableObserver;

  @Inject public TopTenSongsPresenterImpl(TopTenSongsView view) {
    this.view = view;
    topTenSongsInteractor = new TopTenSongsInteractorImpl();
  }

  @Override public void getTopTenSongs(String artistId) {
    if (null != view) view.showProgress();
    disposableObserver = new DisposableObserver<SpotifySongsResponse>() {
      @Override public void onNext(SpotifySongsResponse spotifySongsResponse) {
        view.hideProgress();
        view.showSongs(spotifySongsResponse.getTracks());
      }

      @Override public void onError(Throwable e) {
        view.hideProgress();
        view.showError(e.getMessage());
      }

      @Override public void onComplete() {
        view.hideProgress();
      }
    };
    topTenSongsInteractor.getTopTenSongsByArtist(artistId)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(disposableObserver);
  }

  @Override public void destroy() {
    view = null;
    if (null != disposableObserver && !disposableObserver.isDisposed()) {
      disposableObserver.dispose();
    }
  }
}
