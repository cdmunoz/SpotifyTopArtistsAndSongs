package co.medellinandroid.spotifyartists.di.module;

import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsPresenter;
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsPresenterImpl;
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsView;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class ArtistsModule {

  TopTenArtistsView topTenArtistsView;

  public ArtistsModule(TopTenArtistsView topTenArtistsView) {
    this.topTenArtistsView = topTenArtistsView;
  }

  @Provides @Singleton TopTenArtistsView providesTopTenArtistView(){
    return topTenArtistsView;
  }

  @Provides TopTenArtistsPresenter providesTopTenArtistPresenter(TopTenArtistsView topTenArtistsView){
    return new TopTenArtistsPresenterImpl(topTenArtistsView);
  }
}
