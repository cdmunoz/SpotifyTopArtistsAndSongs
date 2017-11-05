package co.medellinandroid.spotifyartists.rest

import co.medellinandroid.spotifyartists.utils.Constants.Companion.ACCESS_TOKEN
import co.medellinandroid.spotifyartists.utils.Constants.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiInterceptor : Interceptor {

  @Throws(IOException::class)
  override fun intercept(chain: Interceptor.Chain): Response {

    val original = chain.request()
    val request = original.newBuilder()
        .header(API_KEY, ACCESS_TOKEN)
        .method(original.method(), original.body())
        .build()
    return chain.proceed(request)
  }
}
