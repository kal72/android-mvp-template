package id.kal.myarchitecture.ui.base;

/**
 * Contributor Kristiawan Adi L on 15/12/18.
 */
public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
