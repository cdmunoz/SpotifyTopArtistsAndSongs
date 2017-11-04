package co.medellinandroid.spotifyartists.topTenSongs;

import co.medellinandroid.spotifyartists.model.SpotifyTrack;
import java.util.List;

public interface TopTenSongsContract {

  interface View {
    void showProgress();

    void hideProgress();

    void showError(String message);

    void showSongs(List<SpotifyTrack> tracks);
  }

  interface Presenter {
    void attachView(View view);

    void getTopTenSongs(String artistId);

    void destroy();
  }
}
