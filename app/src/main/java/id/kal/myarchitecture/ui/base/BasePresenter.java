package id.kal.myarchitecture.ui.base;

import javax.inject.Inject;

import id.kal.myarchitecture.data.DataManager;
import id.kal.myarchitecture.exception.MvpViewNotAttachedException;
import io.reactivex.disposables.Disposable;

/**
 * Contributor Kristiawan Adi L on 15/12/18.
 */
public class BasePresenter<T extends MvpView> implements MvpPresenter<T> {

    private final DataManager dataManager;
    protected Disposable rxDisposable;

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
        if (rxDisposable != null) {
            rxDisposable.dispose();
        }
    }

    private boolean isViewAttached() {
        return mMvpView != null;
    }

    protected T getView() {
        checkViewAttached();
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    protected DataManager getDataManager() {
        return dataManager;
    }
}
