package co.medellinandroid.spotifyartists.di.module

import co.medellinandroid.spotifyartists.rest.ApiInterceptor
import co.medellinandroid.spotifyartists.rest.ApiInterface
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class NetModule(var baseUrl: String) {

  @Provides
  @Singleton internal fun providesApiInterceptor(): ApiInterceptor = ApiInterceptor()

  @Provides
  @Singleton internal fun providesOkHttpClient(apiInterceptor: ApiInterceptor): OkHttpClient {
    return OkHttpClient.Builder().addNetworkInterceptor(StethoInterceptor())
        .addInterceptor(apiInterceptor)
        .build()
  }

  @Provides
  @Singleton internal fun providesMoshi(): Moshi = Moshi.Builder().build()

  @Provides
  @Singleton internal fun providesRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder().client(okHttpClient)
        .baseUrl(baseUrl)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
  }

  @Provides internal fun providesApiInterface(retrofit: Retrofit): ApiInterface =
      retrofit.create(ApiInterface::class.java)
}
