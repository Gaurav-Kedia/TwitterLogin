package com.gaurav.log.api;

import com.twitter.sdk.android.core.models.Tweet;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface TimelineService {
    @GET("/1.1/statuses/home_timeline.json")
    void homeTimeline(@Query("count") Integer count,
                      @Query("trim_user") boolean trim_user,
                      @Query("exclude_replies") boolean exclude_replies,
                      @Query("contribution_details") boolean contribution_details,
                      @Query("include_entities") boolean include_entities,
                      Callback<List<Tweet>> callback);
}
