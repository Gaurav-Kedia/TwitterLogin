package com.gaurav.log.api;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;

public class CustomTwitterApiClient extends TwitterApiClient {
    public CustomTwitterApiClient(Session session) {
        super(session);
    }
    public TimelineService getTimelineService(){
        return getService(TimelineService.class);
    }
}
