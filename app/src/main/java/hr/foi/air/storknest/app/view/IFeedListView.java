package hr.foi.air.storknest.app.view;

import java.util.ArrayList;
import java.util.List;

import hr.foi.air.storknest.app.model.FeedModel;

public interface IFeedListView {
    void onFeedList(ArrayList<FeedModel> feeds);
}
