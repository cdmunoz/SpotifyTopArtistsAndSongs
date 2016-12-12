package co.cmunoz.myspotifycontents.topTenArtists;

import co.cmunoz.myspotifycontents.model.SpotifyArtistsResponse;
import rx.Observable;

/**
 * Top ten artist interactor interface
 *
 * User: cmunoz
 * Date: 12/7/16
 * Time: 11:40 AM
 */

public interface TopTenArtistsInteractor {

  Observable<SpotifyArtistsResponse> getTopTenArtists();
}
