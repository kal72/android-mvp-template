package id.kal.myarchitecture.ui.Main;

import id.kal.myarchitecture.data.network.model.BaseResponseObject;
import id.kal.myarchitecture.data.network.model.Hello;
import id.kal.myarchitecture.ui.base.MvpPresenter;
import id.kal.myarchitecture.ui.base.MvpView;

/**
 * Contributor Kristiawan Adi L on 18/12/18.
 * For example
 */
public interface MainContract {

    interface View extends MvpView {
        void onSuccess(String token);

        void onLoadSuccess(BaseResponseObject<Hello> responseObject);

        void onLoadError(String error);
    }

    interface Presenter extends MvpPresenter<View> {

        void saveToken(String token);

        String getToken();

        void helloWord();
    }
}
