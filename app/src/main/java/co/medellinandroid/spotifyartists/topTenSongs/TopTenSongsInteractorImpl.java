package co.medellinandroid.spotifyartists.topTenSongs;

import co.medellinandroid.spotifyartists.model.SpotifySongsResponse;
import co.medellinandroid.spotifyartists.rest.ApiClient;
import co.medellinandroid.spotifyartists.rest.ApiInterface;
import co.medellinandroid.spotifyartists.utils.Constants;
import io.reactivex.Observable;

public class TopTenSongsInteractorImpl implements TopTenSongsInteractor {

  @Override public Observable<SpotifySongsResponse> getTopTenSongsByArtist(String artistId) {
    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    return apiInterface.getTopTenSongsByArtist(artistId, Constants.COUNTRY_MARKET);
  }
}
