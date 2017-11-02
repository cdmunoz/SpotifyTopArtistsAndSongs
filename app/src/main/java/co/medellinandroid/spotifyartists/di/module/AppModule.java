package co.medellinandroid.spotifyartists.di.module;

import co.medellinandroid.spotifyartists.MyApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class AppModule {

  MyApplication application;

  public AppModule(MyApplication application) {
    this.application = application;
  }

  @Provides @Singleton MyApplication providesApplication(){
    return application;
  }
}
