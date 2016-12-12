package co.cmunoz.myspotifycontents.topTenSongs;

import co.cmunoz.myspotifycontents.model.SpotifyTrack;
import java.util.List;

/**
 * Description
 *
 * User: cmunoz
 * Date: 12/10/16
 * Time: 12:43 PM
 */
public interface TopTenSongsView {

  void showProgress();
  void hideProgress();
  void showError(String message);
  void showSongs(List<SpotifyTrack> tracks);
}
