package id.kal.myarchitecture.data.network.model;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
public class BaseResponseObject<T> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
