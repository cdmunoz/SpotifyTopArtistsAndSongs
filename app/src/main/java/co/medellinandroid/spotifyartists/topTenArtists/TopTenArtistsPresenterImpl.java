package co.medellinandroid.spotifyartists.topTenArtists;

import co.medellinandroid.spotifyartists.model.SpotifyArtistsResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class TopTenArtistsPresenterImpl implements TopTenArtistsPresenter {

  private TopTenArtistsView view;
  private TopTenArtistsInteractor topTenArtistsInteractor;
  private DisposableObserver<SpotifyArtistsResponse> disposableObserver;

  public TopTenArtistsPresenterImpl(TopTenArtistsView view) {
    this.view = view;
    this.topTenArtistsInteractor = new TopTenArtistsInteractorImpl();
  }

  @Override public void getTopTenArtists() {
    if (null != view) view.showProgress();
    disposableObserver = new DisposableObserver<SpotifyArtistsResponse>() {
      @Override public void onNext(SpotifyArtistsResponse spotifyArtistsResponse) {
        view.hideProgress();
        view.showList(spotifyArtistsResponse.getArtists().getItems());
      }

      @Override public void onError(Throwable e) {
        view.hideProgress();
        view.showError(e.getMessage());
      }

      @Override public void onComplete() {
        view.hideProgress();
      }
    };

    topTenArtistsInteractor.getTopTenArtists()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(disposableObserver);
  }

  @Override public void onDestroy() {
    view = null;
    if (null != disposableObserver && !disposableObserver.isDisposed()) {
      disposableObserver.dispose();
    }
  }
}
