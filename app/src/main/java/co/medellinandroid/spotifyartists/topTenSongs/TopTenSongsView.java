package co.medellinandroid.spotifyartists.topTenSongs;

import co.medellinandroid.spotifyartists.model.SpotifyTrack;
import java.util.List;

public interface TopTenSongsView {

  void showProgress();

  void hideProgress();

  void showError(String message);

  void showSongs(List<SpotifyTrack> tracks);
}
