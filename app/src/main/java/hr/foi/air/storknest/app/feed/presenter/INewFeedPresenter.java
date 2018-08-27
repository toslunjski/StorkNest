package hr.foi.air.storknest.app.feed.presenter;


import android.widget.RadioButton;

import com.google.firebase.auth.FirebaseUser;

public interface INewFeedPresenter {
    void onSaveFeed(String user, RadioButton selectedFeedType, RadioButton selectedFeedAmount);
}
