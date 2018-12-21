package id.kal.myarchitecture.data.network.config;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import id.kal.myarchitecture.BuildConfig;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
@Singleton
public class ApiConfig {

    private Retrofit retrofit;

    private ApiHeader apiHeader;

    @Inject
    public ApiConfig(ApiHeader apiHeader) {
        this.apiHeader = apiHeader;
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiEndPoint.BASE_API)
                .callbackExecutor(Executors.newCachedThreadPool())
                .validateEagerly(true)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(setupOkHttpClient().build())
                .build();
    }

    private OkHttpClient.Builder setupOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(0, TimeUnit.SECONDS);
        httpClient.readTimeout(0, TimeUnit.SECONDS);
        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder().addHeader("Authorization",apiHeader.getApiToken()).build();
            return chain.proceed(request);
        });

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (BuildConfig.DEBUG) {
            httpClient.addInterceptor(logging);
        }

        return httpClient;
    }

    public ApiHeader getApiHeader() {
        return apiHeader;
    }

    public <T>T buildService(Class<T> apiInterface) {
        return retrofit.create(apiInterface);
    }
}
