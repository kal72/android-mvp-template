package id.kal.myarchitecture.ui.Main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

import id.kal.myarchitecture.R;
import id.kal.myarchitecture.ui.base.BaseActivity;

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

        ((Button) findViewById(R.id.button_generate)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().saveToken(UUID.randomUUID().toString());
            }
        });
    }

    @Override
    public void onSuccess(String token) {
        ((TextView) findViewById(R.id.text_main)).setText("token is : " + token);
    }

    @Override
    public void onShowProgress() {

    }

    @Override
    public void onRemoveProgress() {

    }
}
