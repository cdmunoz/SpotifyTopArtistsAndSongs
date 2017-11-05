package co.medellinandroid.spotifyartists.di.component

import co.medellinandroid.spotifyartists.MyApplication
import co.medellinandroid.spotifyartists.di.module.AppModule
import co.medellinandroid.spotifyartists.di.module.NetModule
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsInteractor
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsInteractor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class, NetModule::class))
interface AppComponent {

  fun inject(application: MyApplication)
  fun inject(topTenArtistsInteractor: TopTenArtistsInteractor)
  fun inject(topTenSongsInteractor: TopTenSongsInteractor)
}
