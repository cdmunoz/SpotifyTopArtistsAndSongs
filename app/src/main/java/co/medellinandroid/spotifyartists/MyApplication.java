package co.medellinandroid.spotifyartists;

import android.app.Application;
import android.os.SystemClock;
import co.medellinandroid.spotifyartists.di.component.AppComponent;
import co.medellinandroid.spotifyartists.di.component.DaggerAppComponent;
import co.medellinandroid.spotifyartists.di.module.AppModule;
import co.medellinandroid.spotifyartists.di.module.NetModule;
import com.facebook.stetho.Stetho;

public class MyApplication extends Application {

  public MyApplication getApplication() {
    return application;
  }

  public static MyApplication application;

  public AppComponent getAppComponent() {
    return appComponent;
  }

  AppComponent appComponent;

  MyApplication app;

  @Override public void onCreate() {
    super.onCreate();

    application = this;

    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .netModule(new NetModule("https://api.spotify.com/v1/"))
        .build();
    appComponent.inject(this);

    Stetho.initializeWithDefaults(this);
    SystemClock.sleep(3000);
  }
}
