package co.cmunoz.myspotifycontents.topTenSongs;

import co.cmunoz.myspotifycontents.model.SpotifySongsResponse;
import rx.Observable;

/**
 * Interface of top ten songs by artists interactor
 *
 * User: cmunoz
 * Date: 12/10/16
 * Time: 12:47 PM
 */

public interface TopTenSongsInteractor {

  Observable<SpotifySongsResponse> getTopTenSongsByArtist(String artistId);
}
