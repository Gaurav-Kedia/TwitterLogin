package com.gaurav.log;

import android.app.Application;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

public class TwitterClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterConfig config = new TwitterConfig.Builder(this)

                .twitterAuthConfig(new TwitterAuthConfig(BuildConfig.TWITTER_KEY,BuildConfig.TWITTER_SECRET))

                .build();

        Twitter.initialize(config);
    }
}
