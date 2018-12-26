package id.kal.myarchitecture.ui.Main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

import id.kal.myarchitecture.R;
import id.kal.myarchitecture.data.network.model.BaseResponseObject;
import id.kal.myarchitecture.data.network.model.Hello;
import id.kal.myarchitecture.ui.base.BaseActivity;
import id.kal.myarchitecture.utils.Logger;

/**
 * Contributor Kristiawan Adi L on 15/12/18.
 * For Example
 */
public class MainActivity extends BaseActivity<MainContract.Presenter> implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPresenter().attachView(this);

        ((Button) findViewById(R.id.button_generate)).setOnClickListener(v -> {
            getPresenter().helloWord();
            Logger.d(MainActivity.this, getPresenter().getToken());
        });
    }

    @Override
    public void onSuccess(String token) {

    }

    @Override
    public void onLoadSuccess(BaseResponseObject<Hello> responseObject) {
        ((TextView) findViewById(R.id.text_main)).setText("message : "+ responseObject.getData().getMessage());
    }

    @Override
    public void onLoadError(String error) {
        Logger.e(this, error);
    }

    @Override
    public void onShowProgress() {
        Logger.d(MainActivity.this, "progress");
    }

    @Override
    public void onRemoveProgress() {
        Logger.d(MainActivity.this, "remove progress");
    }
}
