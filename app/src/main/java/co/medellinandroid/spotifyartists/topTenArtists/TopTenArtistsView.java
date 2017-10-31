package co.medellinandroid.spotifyartists.topTenArtists;

import co.medellinandroid.spotifyartists.model.SpotifyArtistsItems;
import java.util.List;

public interface TopTenArtistsView {

  void showProgress();

  void hideProgress();

  void showError(String message);

  void showList(List<SpotifyArtistsItems> topTenArtists);
}
