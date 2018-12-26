package id.kal.myarchitecture.data.network.model;

import java.util.List;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
public class BaseResponseList<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
