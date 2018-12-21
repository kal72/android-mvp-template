package id.kal.myarchitecture.di.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import id.kal.myarchitecture.data.DataManagerImpl;
import id.kal.myarchitecture.data.DataManager;
import id.kal.myarchitecture.data.network.ApiHelper;
import id.kal.myarchitecture.data.network.ApiHelperImpl;
import id.kal.myarchitecture.data.network.config.ApiHeader;
import id.kal.myarchitecture.data.network.config.ApiHeaderImpl;
import id.kal.myarchitecture.data.pref.SharedPreferencesHelperImpl;
import id.kal.myarchitecture.data.pref.SharedPreferencesHelper;
import id.kal.myarchitecture.di.PreferenceInfo;
import id.kal.myarchitecture.utils.AppConstants;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 */
@Module
public abstract class AppModule {

    @Binds
    abstract Context bindContext(Application application);

    @Binds
    @Singleton
    abstract DataManager bindDataManager(DataManagerImpl dataManager);

    @Binds
    @Singleton
    abstract SharedPreferencesHelper bindPreferencesHelper(SharedPreferencesHelperImpl sharedPreferencesHelper);

    @Binds
    @Singleton
    abstract ApiHelper bindApiHelper(ApiHelperImpl apiHelper);

    @Binds
    @Singleton
    abstract ApiHeader bindApiHeader(ApiHeaderImpl apiHeader);

    @Provides
    @PreferenceInfo
    static String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }
}
