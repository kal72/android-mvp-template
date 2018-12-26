package id.kal.myarchitecture.data.network;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.kal.myarchitecture.data.network.config.ApiConfig;
import id.kal.myarchitecture.data.network.config.ApiHeader;
import id.kal.myarchitecture.data.network.service.HelloApiService;
import id.kal.myarchitecture.utils.Logger;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
@Singleton
public class ApiHelperImpl implements ApiHelper {

    private ApiConfig apiConfig;

    private HelloApiService helloApiService;

    @Inject
    public ApiHelperImpl(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    @Inject
    public void setHelloApiService(HelloApiService helloApiService) {
        this.helloApiService = helloApiService;
    }

    @Override
    public ApiHeader getApiHeader() {
        return apiConfig.getApiHeader();
    }

    @Override
    public HelloApiService getHelloApiService() {
        if (helloApiService == null)
        Logger.d(this, "null");

        return helloApiService;
    }
}
