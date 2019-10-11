package com.gaurav.log;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.crashlytics.android.Crashlytics;
import com.gaurav.log.main.MainActivity;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.fabric.sdk.android.Fabric;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.twitterLoginButton)
    TwitterLoginButton twitterLoginButton;
    @BindView(R.id.container)
    RelativeLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        twitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                naviagtetomainscreen();
            }
            @Override
            public void failure(TwitterException e) {
                @SuppressLint({"StringFormatInvalid", "LocalSuppress"}) String msgError = String.format(getString(R.string.login_error_message),
                        e.getLocalizedMessage());
                Snackbar.make(container, msgError, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    private void naviagtetomainscreen() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        twitterLoginButton.onActivityResult(requestCode, resultCode, data);
    }
}
