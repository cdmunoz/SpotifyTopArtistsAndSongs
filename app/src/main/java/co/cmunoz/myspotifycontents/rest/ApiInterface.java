package co.cmunoz.myspotifycontents.rest;

import co.cmunoz.myspotifycontents.model.SpotifyArtistsResponse;
import co.cmunoz.myspotifycontents.model.SpotifySongsResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Interface with all the endpoints
 *
 * User: cmunoz
 * Date: 12/9/16
 * Time: 4:05 PM
 */

public interface ApiInterface {

  @GET("search") Observable<SpotifyArtistsResponse> getTopTenArtists(
      @Query(value = "q", encoded = true) String query, @Query("type") String type,
      @Query("market") String market, @Query("limit") int limit);

  @GET("artists/{id}/top-tracks") Observable<SpotifySongsResponse> getTopTenSongsByArtist(
      @Path("id") String artistId, @Query("country") String country);
}
