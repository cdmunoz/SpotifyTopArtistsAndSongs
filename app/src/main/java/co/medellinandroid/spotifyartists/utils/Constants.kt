package co.medellinandroid.spotifyartists.utils

interface Constants {
  companion object {

    val EXTRA_PARAM_ARTIST_ID = "co.medellinandroid.spotifyartists.extra.param.artistId"
    val EXTRA_PARAM_ARTIST_NAME = "co.medellinandroid.spotifyartists.extra.param.artistName"
    val COUNTRY_MARKET = "GB"
    val API_KEY = "Authorization"

    //According to auth pattern <type> <token> never remove the type
    //to get the token, go to https://developer.spotify.com/web-api/console/get-search-item/ a generate it
    //using your own Spotify account info
    val ACCESS_TOKEN = "Bearer BQATlX4W00m0w3-8C26NtQ5MkPKOUnTfJASQ0xlupFTFLzC-HPPHkRSbw8tm9pNZNjDVndPY4c8RGfaC6bMTMyLnIJiD56K_OBag_QiC0wAdnI7mShNRq0GA7YseYVBir9qmyxCqWbXcgk0"
  }
}
