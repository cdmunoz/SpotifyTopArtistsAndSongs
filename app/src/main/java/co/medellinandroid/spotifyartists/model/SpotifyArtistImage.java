package co.medellinandroid.spotifyartists.model;

import com.squareup.moshi.Json;

public class SpotifyArtistImage {

  @Json(name = "height") private int height;
  @Json(name = "width") private int width;
  @Json(name = "url") private String url;

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
