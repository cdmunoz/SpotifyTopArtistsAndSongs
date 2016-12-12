package co.cmunoz.myspotifycontents.model;

import com.google.gson.annotations.SerializedName;

/**
 * Description
 *
 * User: cmunoz
 * Date: 12/9/16
 * Time: 5:34 PM
 */

public class SpotifyArtistsResponse {

  @SerializedName("artists")
  private SpotifyArtists artists;

  public SpotifyArtistsResponse() {
  }

  public SpotifyArtists getArtists() {
    return artists;
  }

  public void setArtists(SpotifyArtists artists) {
    this.artists = artists;
  }
}
