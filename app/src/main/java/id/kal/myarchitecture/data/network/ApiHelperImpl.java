package id.kal.myarchitecture.data.network;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.kal.myarchitecture.data.network.config.ApiConfig;
import id.kal.myarchitecture.data.network.config.ApiHeader;
import id.kal.myarchitecture.data.network.service.HelloApiService;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
@Singleton
public class ApiHelperImpl implements ApiHelper {

    private ApiConfig apiConfig;

    private HelloApiService helloApiService;

    @Inject
    public ApiHelperImpl(ApiConfig apiConfig, HelloApiService helloApiService) {
        this.apiConfig = apiConfig;
        this.helloApiService = helloApiService;
    }

    @Override
    public ApiHeader getApiHeader() {
        return apiConfig.getApiHeader();
    }

    @Override
    public HelloApiService getHelloApiService() {
        return helloApiService;
    }
}
