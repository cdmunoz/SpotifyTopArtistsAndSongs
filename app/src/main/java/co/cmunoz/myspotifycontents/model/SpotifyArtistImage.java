package co.cmunoz.myspotifycontents.model;

import com.google.gson.annotations.SerializedName;

/**
 * Class encapsulating an Spotify's image information
 *
 * User: cmunoz
 * Date: 12/9/16
 * Time: 11:50 AM
 */
public class SpotifyArtistImage {

  @SerializedName("height")
  private int height;
  @SerializedName("width")
  private int width;
  @SerializedName("url")
  private String url;

  public SpotifyArtistImage() {
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
