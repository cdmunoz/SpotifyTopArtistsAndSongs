package co.medellinandroid.spotifyartists.model;

import com.squareup.moshi.Json;

public class SpotifyArtistsResponse {

  @Json(name = "artists") private SpotifyArtists artists;

  public SpotifyArtistsResponse() {
  }

  public SpotifyArtists getArtists() {
    return artists;
  }

  public void setArtists(SpotifyArtists artists) {
    this.artists = artists;
  }
}
