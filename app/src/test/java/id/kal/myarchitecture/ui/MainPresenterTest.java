package id.kal.myarchitecture.ui;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import id.kal.myarchitecture.data.DataManagerImpl;
import id.kal.myarchitecture.data.DataManager;
import id.kal.myarchitecture.data.network.ApiHelper;
import id.kal.myarchitecture.data.network.ApiHelperImpl;
import id.kal.myarchitecture.data.network.config.ApiConfig;
import id.kal.myarchitecture.data.network.config.ApiHeader;
import id.kal.myarchitecture.data.network.model.BaseResponseObject;
import id.kal.myarchitecture.data.network.model.Hello;
import id.kal.myarchitecture.data.network.service.HelloApiService;
import id.kal.myarchitecture.data.pref.SharedPreferencesHelper;
import id.kal.myarchitecture.ui.Main.MainContract;
import id.kal.myarchitecture.ui.Main.MainPresenter;
import id.kal.myarchitecture.utils.RxSchedulersOverrideRule;
import io.reactivex.Observable;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 * For example
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Rule
    public RxSchedulersOverrideRule rule = new RxSchedulersOverrideRule();

    @Mock
    MainContract.View mainView;

    @Mock
    SharedPreferencesHelper sharedPreferencesHelper;

    @Mock
    ApiConfig apiConfig;

    @Mock
    ApiHeader apiHeader;

    @Mock
    HelloApiService helloApiService;

    private DataManager dataManager;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        ApiHelper apiHelper = new ApiHelperImpl(apiConfig);
        apiHelper.setHelloApiService(helloApiService);

        dataManager = new DataManagerImpl(sharedPreferencesHelper, apiHelper);

        mainPresenter = new MainPresenter(dataManager);
        mainPresenter.attachView(mainView);
    }

    @Test
    public void saveSuccess() {
        String token = "token";

        when(dataManager.getApiHelper().getApiHeader()).thenReturn(apiHeader);
        when(sharedPreferencesHelper.getToken()).thenReturn(token);

        mainPresenter.saveToken(token);
        verify(mainView).onSuccess(token);
        verify(mainView, never()).onSuccess("not token");
    }

    @Test
    public void helloWord() {
        BaseResponseObject<Hello> baseResponseObject = new BaseResponseObject<>();
        baseResponseObject.setData(new Hello());

        when(helloApiService.helloWord("Hello guys"))
                .thenReturn(Observable.just(baseResponseObject));

        mainPresenter.helloWord();
        verify(mainView).onLoadSuccess(baseResponseObject);
        verify(mainView, never()).onLoadError(anyString());
    }
}