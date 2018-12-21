package id.kal.myarchitecture.data;

import id.kal.myarchitecture.data.network.ApiHelper;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 */
public interface DataManager  {

    void saveToken(String token);

    String getToken();

    ApiHelper getApiHelper();
}
