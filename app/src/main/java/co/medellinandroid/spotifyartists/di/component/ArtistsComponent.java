package co.medellinandroid.spotifyartists.di.component;

import co.medellinandroid.spotifyartists.di.module.ArtistsModule;
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton @Component(modules = ArtistsModule.class) public interface ArtistsComponent {

  void inject(TopTenArtistsActivity topTenArtistsActivity);
}
