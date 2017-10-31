package co.medellinandroid.spotifyartists.model;

import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;

public class SpotifyArtistsItems {

  @Json(name = "id") private String id;
  @Json(name = "name") private String name;
  @Json(name = "uri") private String uri;
  @Json(name = "images") private List<SpotifyArtistImage> images = new ArrayList<>();

  public SpotifyArtistsItems() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public List<SpotifyArtistImage> getImages() {
    return images;
  }

  public void setImages(List<SpotifyArtistImage> images) {
    this.images = images;
  }

  public static class Builder {

    private SpotifyArtistsItems spotifyArtist = new SpotifyArtistsItems();

    public Builder withName(String name) {
      spotifyArtist.setName(name);
      return this;
    }

    public SpotifyArtistsItems build() {
      return spotifyArtist;
    }
  }
}
