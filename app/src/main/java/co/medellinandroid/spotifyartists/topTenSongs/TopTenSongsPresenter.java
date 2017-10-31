package co.medellinandroid.spotifyartists.topTenSongs;

public interface TopTenSongsPresenter {

  void getTopTenSongs(String artistId);

  void destroy();
}
