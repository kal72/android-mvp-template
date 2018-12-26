package id.kal.myarchitecture.ui.Main;



import javax.inject.Inject;

import id.kal.myarchitecture.data.network.model.BaseResponseObject;
import id.kal.myarchitecture.data.network.model.Hello;
import id.kal.myarchitecture.ui.base.BasePresenter;

import id.kal.myarchitecture.data.DataManager;
import id.kal.myarchitecture.utils.RxUtil;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 * For example
 */
public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void saveToken(String token) {
        getDataManager().saveToken(token);
        getView().onSuccess(getDataManager().getToken());
    }

    @Override
    public String getToken() {
        return getDataManager().getToken();
    }

    @Override
    public void helloWord() {
        getView().onShowProgress();
//        RxUtil.dispose(rxDisposable);
        getDataManager().getApiHelper()
                .getHelloApiService()
                .helloWord("Hello guys")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponseObject<Hello>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        rxDisposable = d;
                    }

                    @Override
                    public void onNext(BaseResponseObject<Hello> baseResponseObject) {
                        getView().onLoadSuccess(baseResponseObject);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onLoadError(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        getView().onRemoveProgress();
                    }
                });
    }
}
