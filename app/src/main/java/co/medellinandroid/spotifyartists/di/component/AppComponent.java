package co.medellinandroid.spotifyartists.di.component;

import co.medellinandroid.spotifyartists.MyApplication;
import co.medellinandroid.spotifyartists.di.module.AppModule;
import co.medellinandroid.spotifyartists.di.module.NetModule;
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsInteractor;
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsInteractor;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

  void inject(MyApplication application);
  void inject(TopTenArtistsInteractor topTenArtistsInteractor);
  void inject(TopTenSongsInteractor topTenSongsInteractor);
}
