package co.medellinandroid.spotifyartists.model;

import com.squareup.moshi.Json;
import java.util.ArrayList;
import java.util.List;

public class SpotifySongsResponse {

  @Json(name = "tracks") private List<SpotifyTrack> tracks = new ArrayList<>();

  public SpotifySongsResponse() {
  }

  public List<SpotifyTrack> getTracks() {
    return tracks;
  }

  public void setTracks(List<SpotifyTrack> tracks) {
    this.tracks = tracks;
  }
}
