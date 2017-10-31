package co.medellinandroid.spotifyartists.topTenArtists;

import co.medellinandroid.spotifyartists.model.SpotifyArtistsResponse;
import co.medellinandroid.spotifyartists.rest.ApiClient;
import co.medellinandroid.spotifyartists.rest.ApiInterface;
import co.medellinandroid.spotifyartists.utils.Constants;
import io.reactivex.Observable;

public class TopTenArtistsInteractorImpl implements TopTenArtistsInteractor {

  @Override public Observable<SpotifyArtistsResponse> getTopTenArtists() {
    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    return apiInterface.getTopTenArtists("year:0000-9999", "artist", Constants.COUNTRY_MARKET, 10);
  }
}
