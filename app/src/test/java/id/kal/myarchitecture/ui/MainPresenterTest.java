package id.kal.myarchitecture.ui;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import id.kal.myarchitecture.data.DataManagerImpl;
import id.kal.myarchitecture.data.DataManager;
import id.kal.myarchitecture.data.network.ApiHelper;
import id.kal.myarchitecture.data.network.config.ApiHeader;
import id.kal.myarchitecture.data.pref.SharedPreferencesHelper;
import id.kal.myarchitecture.ui.Main.MainContract;
import id.kal.myarchitecture.ui.Main.MainPresenter;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Contributor Kristiawan Adi L on 16/12/18.
 * For example
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    MainContract.View mainView;

    @Mock
    SharedPreferencesHelper sharedPreferencesHelper;

    @Mock
    ApiHelper apiHelper;

    @Mock
    ApiHeader apiHeader;

    DataManager dataManager;

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        dataManager = new DataManagerImpl(sharedPreferencesHelper, apiHelper);

        mainPresenter = new MainPresenter(dataManager);
        mainPresenter.attachView(mainView);
    }

    @Test
    public void saveSuccess() {
        String token = "token";

        when(apiHelper.getApiHeader()).thenReturn(apiHeader);
        when(sharedPreferencesHelper.getToken()).thenReturn(token);

        mainPresenter.saveToken(token);
        verify(mainView).onSuccess(token);
        verify(mainView, never()).onSuccess("not token");
    }
}