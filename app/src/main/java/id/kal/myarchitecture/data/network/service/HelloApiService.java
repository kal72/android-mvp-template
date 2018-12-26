package id.kal.myarchitecture.data.network.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.kal.myarchitecture.data.network.config.ApiConfig;
import id.kal.myarchitecture.data.network.config.ApiEndPoint;
import id.kal.myarchitecture.data.network.model.Hello;
import id.kal.myarchitecture.data.network.model.BaseResponseObject;
import io.reactivex.Observable;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
@Singleton
public class HelloApiService {

    private ApiConfig apiConfig;

    @Inject
    public HelloApiService(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    public Observable<BaseResponseObject<Hello>> helloWord(String message){
        return apiConfig
                .buildService(HelloApi.class)
                .helloWord(ApiEndPoint.HELLO, message);
    }
}
