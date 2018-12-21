package id.kal.myarchitecture.data;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.kal.myarchitecture.data.network.ApiHelper;
import id.kal.myarchitecture.data.pref.SharedPreferencesHelper;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 */
@Singleton
public class DataManagerImpl implements DataManager {

    private final SharedPreferencesHelper sharedPreferencesHelper;

    private final ApiHelper apiHelper;

    @Inject
    public DataManagerImpl(SharedPreferencesHelper sharedPreferencesHelper, ApiHelper apiHelper) {
        this.sharedPreferencesHelper = sharedPreferencesHelper;
        this.apiHelper = apiHelper;
    }

    @Override
    public void saveToken(String token) {
        apiHelper.getApiHeader().setApiToken(token);
        if (token != sharedPreferencesHelper.getToken()) {
            sharedPreferencesHelper.setToken(token);
        }
    }

    @Override
    public String getToken() {
        return sharedPreferencesHelper.getToken();
    }

    @Override
    public ApiHelper getApiHelper() {
        return apiHelper;
    }
}
