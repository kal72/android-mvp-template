package id.kal.myarchitecture.ui.base;

import javax.inject.Inject;

import id.kal.myarchitecture.data.DataManager;
import id.kal.myarchitecture.exception.MvpViewNotAttachedException;

/**
 * Contributor Kristiawan Adi L on 15/12/18.
 */
public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    private final DataManager dataManager;

    @Inject
    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    private T mMvpView;

    @Override
    public void attachView(T mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    private boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        checkViewAttached();
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public DataManager getDataManager() {
        return dataManager;
    }
}
