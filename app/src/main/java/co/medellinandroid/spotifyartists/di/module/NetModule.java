package co.medellinandroid.spotifyartists.di.module;

import co.medellinandroid.spotifyartists.rest.ApiInterceptor;
import co.medellinandroid.spotifyartists.rest.ApiInterface;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.moshi.Moshi;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module public class NetModule {

  String baseUrl;

  public NetModule(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  @Provides @Singleton ApiInterceptor providesApiInterceptor() {
    return new ApiInterceptor();
  }

  @Provides @Singleton OkHttpClient providesOkHttpClient(ApiInterceptor apiInterceptor) {
    return new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor())
        .addInterceptor(apiInterceptor)
        .build();
  }

  @Provides @Singleton Moshi providesMoshi() {
    return new Moshi.Builder().build();
  }

  @Provides @Singleton Retrofit providesRetrofit(OkHttpClient okHttpClient, Moshi moshi) {
    return new Retrofit.Builder().client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  @Provides ApiInterface providesApiInterface(Retrofit retrofit) {
    return retrofit.create(ApiInterface.class);
  }
}
