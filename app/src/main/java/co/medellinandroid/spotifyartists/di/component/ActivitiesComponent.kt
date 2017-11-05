package co.medellinandroid.spotifyartists.di.component

import co.medellinandroid.spotifyartists.di.module.PresentersModule
import co.medellinandroid.spotifyartists.topTenArtists.TopTenArtistsActivity
import co.medellinandroid.spotifyartists.topTenSongs.TopTenSongsActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(PresentersModule::class))
interface ActivitiesComponent {

  fun inject(topTenArtistsActivity: TopTenArtistsActivity)
  fun inject(topTenSongsActivity: TopTenSongsActivity)
}
