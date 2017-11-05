package co.medellinandroid.spotifyartists.di.module

import co.medellinandroid.spotifyartists.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(internal var application: MyApplication) {

  @Provides
  @Singleton internal fun providesApplication(): MyApplication = application
}
