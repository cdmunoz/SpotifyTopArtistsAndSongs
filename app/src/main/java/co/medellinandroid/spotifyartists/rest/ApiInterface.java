package co.medellinandroid.spotifyartists.rest;

import co.medellinandroid.spotifyartists.model.SpotifyArtistsResponse;
import co.medellinandroid.spotifyartists.model.SpotifySongsResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

  @GET("search") Observable<SpotifyArtistsResponse> getTopTenArtists(
      @Query(value = "q", encoded = true) String query, @Query("type") String type,
      @Query("market") String market, @Query("limit") int limit);

  @GET("artists/{id}/top-tracks") Observable<SpotifySongsResponse> getTopTenSongsByArtist(
      @Path("id") String artistId, @Query("country") String country);
}
