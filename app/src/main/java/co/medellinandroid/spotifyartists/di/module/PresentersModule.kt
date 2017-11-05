package co.medellinandroid.spotifyartists.di.module

import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsPresenter
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresentersModule {

  @Provides
  @Singleton internal fun providesTopTenArtistPresenter(): TopTenArtistsPresenter =
      TopTenArtistsPresenter()

  @Provides
  @Singleton internal fun providesTopTenSongsPresenter(): TopTenSongsPresenter =
      TopTenSongsPresenter()
}
