package id.kal.myarchitecture.data.pref;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.kal.myarchitecture.di.PreferenceInfo;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 */
@Singleton
public class SharedPreferencesHelperImpl implements SharedPreferencesHelper {

    private final SharedPreferences mPrefs;
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF = "PREF";

    @Inject
    public SharedPreferencesHelperImpl(Context context, @PreferenceInfo String prefName) {
        mPrefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    @Override
    public String getToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "");
    }

    @Override
    public void setToken(String token) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, token).apply();
    }
}
