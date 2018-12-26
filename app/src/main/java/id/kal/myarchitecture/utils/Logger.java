package id.kal.myarchitecture.utils;

import id.kal.myarchitecture.BuildConfig;
import timber.log.Timber;

/**
 * Contributor Kristiawan Adi L on 23/12/18.
 */
public class Logger {

    public static void init() {
        if (BuildConfig.DEBUG){
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static void d(Object tag, String message){
        Timber.tag(tag.getClass().getSimpleName()).d(message);
    }

    public static void e(Object tag, String message){
        Timber.tag(tag.getClass().getSimpleName()).e(message);
    }

    public static void v(Object tag, String message){
        Timber.tag(tag.getClass().getSimpleName()).e(message);
    }

    public static void i(Object tag, String message){
        Timber.tag(tag.getClass().getSimpleName()).i(message);
    }

    public static void w(Object tag, String message){
        Timber.tag(tag.getClass().getSimpleName()).w(message);
    }
}
