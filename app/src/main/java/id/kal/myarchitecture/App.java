package id.kal.myarchitecture;


import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import id.kal.myarchitecture.di.component.AppComponent;
import id.kal.myarchitecture.di.component.DaggerAppComponent;
import id.kal.myarchitecture.utils.Logger;

/**
 * Contributor Kristiawan Adi L on 15/12/18.
 */
public class App extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);

        return appComponent;
    }
}
