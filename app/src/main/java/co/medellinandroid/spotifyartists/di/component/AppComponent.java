package co.medellinandroid.spotifyartists.di.component;

import co.medellinandroid.spotifyartists.MyApplication;
import co.medellinandroid.spotifyartists.di.module.AppModule;
import co.medellinandroid.spotifyartists.di.module.NetModule;
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsInteractorImpl;
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsInteractorImpl;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

  void inject(MyApplication application);
  void inject(TopTenArtistsInteractorImpl topTenArtistsInteractor);
  void inject(TopTenSongsInteractorImpl topTenSongsInteractor);
}
