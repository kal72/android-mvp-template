package id.kal.myarchitecture.ui.Main;


import javax.inject.Inject;

import id.kal.myarchitecture.ui.base.BasePresenter;

import id.kal.myarchitecture.data.DataManager;

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
        getMvpView().onSuccess(getDataManager().getToken());
    }

    @Override
    public String getToken() {
        return getDataManager().getToken();
    }
}
