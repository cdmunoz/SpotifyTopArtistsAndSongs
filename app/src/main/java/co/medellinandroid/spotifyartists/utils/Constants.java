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
      "Bearer BQBSqHfvoiSgkagA7M-fdZRGcGZDImgC39mfvV50aZikmGjy2UyjSVglvK8LLefcWYBkA1jOpuLxAjicOCim_307yXoIi6RBTdHS_Ycr4cAX2lnw4x1w1uuuZqJTX_sY5t1hgpzudYDATvU";
}
