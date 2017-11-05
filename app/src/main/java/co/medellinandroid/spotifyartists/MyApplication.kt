package co.medellinandroid.spotifyartists

import android.app.Application
import android.os.SystemClock
import co.medellinandroid.spotifyartists.di.component.AppComponent
import co.medellinandroid.spotifyartists.di.component.DaggerAppComponent
import co.medellinandroid.spotifyartists.di.module.AppModule
import co.medellinandroid.spotifyartists.di.module.NetModule
import com.facebook.stetho.Stetho

class MyApplication : Application() {

  companion object {
    lateinit var application: MyApplication
  }

  val appComponent: AppComponent by lazy {
    DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .netModule(NetModule("https://api.spotify.com/v1/"))
        .build()
  }

  fun getApplication(): MyApplication = application

  override fun onCreate() {
    super.onCreate()
    application = this
    appComponent.inject(this)

    Stetho.initializeWithDefaults(this)
    SystemClock.sleep(3000)
  }
}
