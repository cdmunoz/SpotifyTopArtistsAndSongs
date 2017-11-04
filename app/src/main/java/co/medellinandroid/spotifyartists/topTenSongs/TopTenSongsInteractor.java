package co.medellinandroid.spotifyartists.topTenSongs;

import co.medellinandroid.spotifyartists.MyApplication;
import co.medellinandroid.spotifyartists.model.SpotifySongsResponse;
import co.medellinandroid.spotifyartists.rest.ApiInterface;
import co.medellinandroid.spotifyartists.utils.Constants;
import io.reactivex.Observable;
import javax.inject.Inject;

public class TopTenSongsInteractor {

  @Inject ApiInterface apiInterface;

  public TopTenSongsInteractor() {
    MyApplication.application.getAppComponent().inject(this);
  }

  public Observable<SpotifySongsResponse> getTopTenSongsByArtist(String artistId) {
    return apiInterface.getTopTenSongsByArtist(artistId, Constants.COUNTRY_MARKET);
  }
}
