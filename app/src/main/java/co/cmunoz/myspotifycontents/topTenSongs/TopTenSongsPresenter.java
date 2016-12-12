package co.cmunoz.myspotifycontents.topTenSongs;

/**
 * Interface presenter top ten songs
 *
 * User: cmunoz
 * Date: 12/10/16
 * Time: 12:41 PM
 */
public interface TopTenSongsPresenter {

  void getTopTenSongs(String artistId);
  void destroy();
}
