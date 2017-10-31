package co.medellinandroid.spotifyartists.utils;

public interface Constants {

  String EXTRA_PARAM_ARTIST_ID = "co.medellinandroid.spotifyartists.extra.param.artistId";
  String EXTRA_PARAM_ARTIST_NAME = "co.medellinandroid.spotifyartists.extra.param.artistName";
  String COUNTRY_MARKET = "GB";
  String API_KEY = "Authorization";

  //According to auth pattern <type> <token> never remove the type
  //to get the token, go to https://developer.spotify.com/web-api/console/get-search-item/ a generate it
  //using your own Spotify account info
  String ACCESS_TOKEN =
      "Bearer BQBgwzxss93ipdvEXFcyOnYzUZ9N8KXi3vuRrKM-7iz1TN27ozI_DONyoCCba9All6W3amXRBqBYjbbsZDuNysOafj4y0SMZbfam98UO3JV0ACJU51t5WLvssi5cQkzRH0DWJwCQ1iCxRE4";
}
