package co.medellinandroid.spotifyartists.topTenSongs;

import co.medellinandroid.spotifyartists.model.SpotifySongsResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class TopTenSongsPresenter implements TopTenSongsContract.Presenter {

  private TopTenSongsContract.View view;
  private TopTenSongsInteractor topTenSongsInteractor;
  private DisposableObserver<SpotifySongsResponse> disposableObserver;

  @Inject public TopTenSongsPresenter() {
    topTenSongsInteractor = new TopTenSongsInteractor();
  }

  @Override public void attachView(TopTenSongsContract.View view) {
    this.view = view;
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
