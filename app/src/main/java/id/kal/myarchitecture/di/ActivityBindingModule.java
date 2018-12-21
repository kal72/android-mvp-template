package id.kal.myarchitecture.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import id.kal.myarchitecture.ui.Main.MainActivity;
import id.kal.myarchitecture.ui.Main.MainActivityModule;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 * Register activity module on this Binding module
 */
@Module
public abstract class ActivityBindingModule {

    /** for example **/
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
