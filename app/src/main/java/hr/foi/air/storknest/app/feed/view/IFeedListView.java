package hr.foi.air.storknest.app.feed.view;

import java.util.ArrayList;

import hr.foi.air.storknest.app.feed.model.FeedModel;

public interface IFeedListView {
    void onFeedList(ArrayList<FeedModel> feeds);
}
