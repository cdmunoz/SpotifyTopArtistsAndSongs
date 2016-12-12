package co.cmunoz.myspotifycontents.topTenSongs;

import co.cmunoz.myspotifycontents.model.SpotifySongsResponse;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Description
 *
 * User: cmunoz
 * Date: 12/10/16
 * Time: 12:45 PM
 */
public class TopTenSongsPresenterImpl implements TopTenSongsPresenter {

  private TopTenSongsView view;
  private TopTenSongsInteractor topTenSongsInteractor;

  public TopTenSongsPresenterImpl(TopTenSongsView view) {
    this.view = view;
    topTenSongsInteractor = new TopTenSongsInteractorImpl();
  }

  @Override public void getTopTenSongs(String artistId) {
    if(null != view) view.showProgress();
    topTenSongsInteractor.getTopTenSongsByArtist(artistId).subscribeOn(Schedulers.newThread()).observeOn(
        AndroidSchedulers.mainThread()).subscribe(new Subscriber<SpotifySongsResponse>() {
      @Override public void onCompleted() {
        view.hideProgress();
      }

      @Override public void onError(Throwable e) {
        view.hideProgress();
        view.showError(e.getMessage());
      }

      @Override public void onNext(SpotifySongsResponse spotifySongsResponse) {
        view.hideProgress();
        view.showSongs(spotifySongsResponse.getTracks());
      }
    });
  }

  @Override public void destroy() {
    view = null;
  }
}
