package co.cmunoz.myspotifycontents.topTenArtists;

import co.cmunoz.myspotifycontents.model.SpotifyArtistsItems;
import java.util.List;

/**
 * Interface for top ten artists
 *
 * User: cmunoz
 * Date: 12/7/16
 * Time: 11:37 AM
 */

public interface TopTenArtistsView {

  void showProgress();
  void hideProgress();
  void showError(String message);
  void showList(List<SpotifyArtistsItems> topTenArtists);
}
