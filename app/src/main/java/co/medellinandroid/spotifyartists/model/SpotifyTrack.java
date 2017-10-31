package co.medellinandroid.spotifyartists.model;

import com.squareup.moshi.Json;

public class SpotifyTrack {

  @Json(name = "id") private String id;
  @Json(name = "name") private String name;
  @Json(name = "duration_ms") private int duration;
  @Json(name = "album") private SpotifyAlbum album;

  public SpotifyTrack() {
    this.album = new SpotifyAlbum();
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

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public SpotifyAlbum getAlbum() {
    return album;
  }

  public void setAlbum(SpotifyAlbum album) {
    this.album = album;
  }
}
