package co.medellinandroid.spotifyartists.di.component;

import co.medellinandroid.spotifyartists.di.module.SongsModule;
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = SongsModule.class) public interface SongsComponent {
  void inject(TopTenSongsActivity topTenSongsActivity);
}
