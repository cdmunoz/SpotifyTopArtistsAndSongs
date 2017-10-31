package co.medellinandroid.spotifyartists;

import android.app.Application;
import android.os.SystemClock;
import com.facebook.stetho.Stetho;

public class MyApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();

    Stetho.initializeWithDefaults(this);
    SystemClock.sleep(3000);
  }
}
