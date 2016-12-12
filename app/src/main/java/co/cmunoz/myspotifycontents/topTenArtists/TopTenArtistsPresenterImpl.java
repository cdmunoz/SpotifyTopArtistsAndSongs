package co.cmunoz.myspotifycontents.topTenArtists;

import co.cmunoz.myspotifycontents.model.SpotifyArtistsResponse;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Class implementing the presenter layer
 *
 * User: cmunoz
 * Date: 12/7/16
 * Time: 11:38 AM
 */

public class TopTenArtistsPresenterImpl implements TopTenArtistsPresenter {

  private TopTenArtistsView view;
  private TopTenArtistsInteractor topTenArtistsInteractor;

  public TopTenArtistsPresenterImpl(TopTenArtistsView view) {
    this.view = view;
    this.topTenArtistsInteractor = new TopTenArtistsInteractorImpl();
  }

  @Override public void getTopTenArtists() {
    if (null != view) view.showProgress();
    topTenArtistsInteractor.getTopTenArtists()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<SpotifyArtistsResponse>() {
          @Override public void onCompleted() {
            view.hideProgress();
          }

          @Override public void onError(Throwable e) {
            view.hideProgress();
            view.showError(e.getMessage());
          }

          @Override public void onNext(SpotifyArtistsResponse spotifyArtistsResponse) {
            view.hideProgress();
            view.showList(spotifyArtistsResponse.getArtists().getItems());
          }
        });
  }

  @Override public void onDestroy() {
    view = null;
  }
}
