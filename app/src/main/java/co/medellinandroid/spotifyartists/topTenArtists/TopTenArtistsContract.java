package co.medellinandroid.spotifyartists.topTenArtists;

import co.medellinandroid.spotifyartists.model.SpotifyArtistsItems;
import java.util.List;

public interface TopTenArtistsContract {

  interface View{
    void showProgress();
    void hideProgress();
    void showError(String message);
    void showList(List<SpotifyArtistsItems> topTenArtists);
  }

  interface Presenter{
    void attachView(View view);
    void getTopTenArtists();
    void onDestroy();
  }
}
