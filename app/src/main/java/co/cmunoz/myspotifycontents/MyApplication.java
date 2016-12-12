package co.cmunoz.myspotifycontents;

import android.app.Application;
import android.os.SystemClock;
import com.facebook.stetho.Stetho;

/**
 * Application class
 *
 * User: cmunoz
 * Date: 12/7/16
 * Time: 11:10 AM
 */

public class MyApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    SystemClock.sleep(3000);
  }
}
