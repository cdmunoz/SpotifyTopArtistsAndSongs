package co.medellinandroid.spotifyartists.topTenArtists;

import co.medellinandroid.spotifyartists.MyApplication;
import co.medellinandroid.spotifyartists.model.SpotifyArtistsResponse;
import co.medellinandroid.spotifyartists.rest.ApiInterface;
import co.medellinandroid.spotifyartists.utils.Constants;
import io.reactivex.Observable;
import javax.inject.Inject;

public class TopTenArtistsInteractorImpl implements TopTenArtistsInteractor {

  @Inject ApiInterface apiInterface;

  public TopTenArtistsInteractorImpl() {
    MyApplication.application.getAppComponent().inject(this);
  }

  @Override public Observable<SpotifyArtistsResponse> getTopTenArtists() {
    return apiInterface.getTopTenArtists("year:0000-9999", "artist", Constants.COUNTRY_MARKET, 10);
  }
}
