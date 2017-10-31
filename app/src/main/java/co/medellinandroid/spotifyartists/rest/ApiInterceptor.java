package co.medellinandroid.spotifyartists.rest;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static co.medellinandroid.spotifyartists.utils.Constants.ACCESS_TOKEN;
import static co.medellinandroid.spotifyartists.utils.Constants.API_KEY;

public class ApiInterceptor implements Interceptor {

  @Override public Response intercept(Chain chain) throws IOException {

    Request original = chain.request();
    Request request = original.newBuilder()
        .header(API_KEY, ACCESS_TOKEN)
        .method(original.method(), original.body())
        .build();
    return chain.proceed(request);
  }
}
