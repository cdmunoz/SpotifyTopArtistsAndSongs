package co.medellinandroid.spotifyartists.topTenArtists;

import co.medellinandroid.spotifyartists.model.SpotifyArtistsResponse;
import io.reactivex.Observable;

public interface TopTenArtistsInteractor {

  Observable<SpotifyArtistsResponse> getTopTenArtists();
}
