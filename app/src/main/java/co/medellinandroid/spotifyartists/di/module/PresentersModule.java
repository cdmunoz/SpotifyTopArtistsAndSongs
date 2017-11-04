package co.medellinandroid.spotifyartists.di.module;

import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsPresenter;
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsPresenter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class PresentersModule {

  @Provides @Singleton TopTenArtistsPresenter providesTopTenArtistPresenter() {
    return new TopTenArtistsPresenter();
  }

  @Provides @Singleton TopTenSongsPresenter providesTopTenSongsPresenter() {
    return new TopTenSongsPresenter();
  }
}
