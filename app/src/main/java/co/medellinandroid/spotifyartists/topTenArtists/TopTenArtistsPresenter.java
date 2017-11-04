package co.medellinandroid.spotifyartists.topTenArtists;

import co.medellinandroid.spotifyartists.model.SpotifyArtistsResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public class TopTenArtistsPresenter implements TopTenArtistsContract.Presenter {

  private TopTenArtistsContract.View view;
  private TopTenArtistsInteractor topTenArtistsInteractor;
  private DisposableObserver<SpotifyArtistsResponse> disposableObserver;

  @Inject public TopTenArtistsPresenter() {
    this.topTenArtistsInteractor = new TopTenArtistsInteractor();
  }

  @Override public void attachView(TopTenArtistsContract.View view) {
    this.view = view;
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
