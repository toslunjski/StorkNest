package hr.foi.air.storknest.app.presenter;

import android.view.View;
import android.widget.RadioButton;

public interface INewFeedPresenter {
    void onSaveFeed(RadioButton selectedFeedType, RadioButton selectedFeedAmount);
}
