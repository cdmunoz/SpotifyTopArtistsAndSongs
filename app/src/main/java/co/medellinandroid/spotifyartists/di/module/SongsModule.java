package co.medellinandroid.spotifyartists.di.module;

import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsPresenter;
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsPresenterImpl;
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsView;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module public class SongsModule {

  TopTenSongsView topTenSongsView;

  public SongsModule(TopTenSongsView topTenSongsView) {
    this.topTenSongsView = topTenSongsView;
  }

  @Provides @Singleton TopTenSongsView providesTopTenSongsView() {
    return topTenSongsView;
  }

  @Provides @Singleton TopTenSongsPresenter providesTopTenSongsPresenter(
      TopTenSongsView topTenSongsView) {
    return new TopTenSongsPresenterImpl(topTenSongsView);
  }
}
