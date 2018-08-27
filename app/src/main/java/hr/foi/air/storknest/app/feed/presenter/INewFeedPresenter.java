package hr.foi.air.storknest.app.feed.presenter;

import android.view.View;
import android.widget.RadioButton;

public interface INewFeedPresenter {
    void onSaveFeed(RadioButton selectedFeedType, RadioButton selectedFeedAmount);
}
