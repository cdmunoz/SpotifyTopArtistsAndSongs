package co.cmunoz.myspotifycontents.topTenArtists;

import co.cmunoz.myspotifycontents.model.SpotifyArtistsResponse;
import co.cmunoz.myspotifycontents.rest.ApiClient;
import co.cmunoz.myspotifycontents.rest.ApiInterface;
import rx.Observable;

/**
 * Implementation of top ten artists interactor
 *
 * User: cmunoz
 * Date: 12/7/16
 * Time: 11:41 AM
 */

public class TopTenArtistsInteractorImpl implements TopTenArtistsInteractor{

  @Override public Observable<SpotifyArtistsResponse> getTopTenArtists() {
    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    return apiInterface.getTopTenArtists("year:0000-9999", "artist", "GB", 10);
  }
}
