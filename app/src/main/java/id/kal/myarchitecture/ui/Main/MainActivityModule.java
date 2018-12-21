package id.kal.myarchitecture.ui.Main;


import dagger.Binds;
import dagger.Module;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 * For example
 */
@Module
public abstract class MainActivityModule {

    @Binds
    public abstract MainContract.Presenter bindMainPresenter(MainPresenter mainPresenter);
}
