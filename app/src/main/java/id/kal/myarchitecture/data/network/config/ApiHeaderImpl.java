package id.kal.myarchitecture.data.network.config;

import javax.inject.Inject;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 */
public class ApiHeaderImpl implements ApiHeader{

    private String token;

    @Inject
    public ApiHeaderImpl() {
        token = "";
    }

    @Override
    public String getApiToken() {
        return token;
    }

    @Override
    public void setApiToken(String token) {
        this.token = token;
    }
}
