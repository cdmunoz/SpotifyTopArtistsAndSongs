package co.cmunoz.myspotifycontents.topTenSongs;

import co.cmunoz.myspotifycontents.model.SpotifySongsResponse;
import co.cmunoz.myspotifycontents.rest.ApiClient;
import co.cmunoz.myspotifycontents.rest.ApiInterface;
import rx.Observable;

/**
 * Implementation of top ten songs interactor
 *
 * User: cmunoz
 * Date: 12/10/16
 * Time: 12:47 PM
 */

public class TopTenSongsInteractorImpl implements TopTenSongsInteractor {

  @Override public Observable<SpotifySongsResponse> getTopTenSongsByArtist(String artistId) {
    ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
    return apiInterface.getTopTenSongsByArtist(artistId, "GB");
  }
}
