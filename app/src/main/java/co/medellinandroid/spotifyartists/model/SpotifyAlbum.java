package co.medellinandroid.spotifyartists.model;

import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;

public class SpotifyAlbum {

  @Json(name = "id") private String id;
  @Json(name = "name") private String name;
  @Json(name = "images") private List<SpotifyAlbumImage> images = new ArrayList<>();

  public SpotifyAlbum() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SpotifyAlbumImage> getImages() {
    return images;
  }

  public void setImages(List<SpotifyAlbumImage> images) {
    this.images = images;
  }
}
