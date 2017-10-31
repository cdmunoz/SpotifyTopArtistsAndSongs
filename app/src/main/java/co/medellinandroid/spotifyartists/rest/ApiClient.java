package co.medellinandroid.spotifyartists.rest;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.moshi.Moshi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ApiClient {

  public static final String BASE_URL = "https://api.spotify.com/v1/";
  private static Retrofit retrofit;

  public static Retrofit getClient() {
    if (null == retrofit) {
      OkHttpClient okHttpClient =
          new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor())
              .addInterceptor(new ApiInterceptor())
              .build();

      Moshi moshi = new Moshi.Builder().build();

      retrofit = new Retrofit.Builder().client(okHttpClient)
          .baseUrl(BASE_URL)
          .addConverterFactory(MoshiConverterFactory.create(moshi))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .build();
    }
    return retrofit;
  }
}
