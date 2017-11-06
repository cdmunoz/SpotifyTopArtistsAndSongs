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
      "Bearer BQB73wLQKSIi0GY0Fz60Nib0WK1SjHWOjWb6X8apVKowFznHej6xa8ObG6LxpL9OBpnui3_0QTgpqjcYXorjywIbY7m7Ev0WIueSMUlxQa5rbtDHLPYzPfFVR7Fs1jJQpSfFKGbNrc8up8s";
}
