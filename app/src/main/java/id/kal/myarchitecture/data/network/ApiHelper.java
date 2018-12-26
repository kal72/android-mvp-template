package id.kal.myarchitecture.data.network;

import id.kal.myarchitecture.data.network.config.ApiHeader;
import id.kal.myarchitecture.data.network.service.BaseService;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
public interface ApiHelper extends BaseService {

    ApiHeader getApiHeader();
}
