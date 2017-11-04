package co.medellinandroid.spotifyartists.di.component;

import co.medellinandroid.spotifyartists.di.module.PresentersModule;
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsActivity;
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = PresentersModule.class) public interface ActivitiesComponent {

  void inject(TopTenArtistsActivity topTenArtistsActivity);
  void inject(TopTenSongsActivity topTenSongsActivity);
}
