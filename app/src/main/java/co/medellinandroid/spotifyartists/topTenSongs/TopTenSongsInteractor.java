package co.medellinandroid.spotifyartists.topTenSongs;

import co.medellinandroid.spotifyartists.model.SpotifySongsResponse;
import io.reactivex.Observable;

public interface TopTenSongsInteractor {

  Observable<SpotifySongsResponse> getTopTenSongsByArtist(String artistId);
}
