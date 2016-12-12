package co.cmunoz.myspotifycontents.rest;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * This class sends network requests and specify base URL for the service
 *
 * User: cmunoz
 * Date: 12/9/16
 * Time: 3:56 PM
 */

public class ApiClient {

  public static final String BASE_URL = "https://api.spotify.com/v1/";
  private static Retrofit retrofit;

  public static Retrofit getClient() {
    if (null == retrofit) {
      OkHttpClient okHttpClient = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();
      retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
          .build();
    }
    return retrofit;
  }
}
