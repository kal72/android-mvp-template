package id.kal.myarchitecture.data.network.service;

import id.kal.myarchitecture.data.network.model.Hello;
import id.kal.myarchitecture.data.network.model.BaseResponseObject;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 * this interface is API Declaration
 *
 */
public interface HelloApi {

    @GET
    Observable<BaseResponseObject<Hello>> helloWord(@Url String url, @Query("message") String message);
}
