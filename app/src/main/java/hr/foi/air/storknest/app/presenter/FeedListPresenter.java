package hr.foi.air.storknest.app.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import hr.foi.air.storknest.app.model.FeedModel;
import hr.foi.air.storknest.app.view.IFeedListView;
import hr.foi.air.storknest.app.view.INewFeedView;

public class FeedListPresenter implements IFeedListPresenter {

    private FirebaseDatabase mDatabase;
    private IFeedListView feedListView;

    public FeedListPresenter(IFeedListView feedListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.feedListView = feedListView;
    }

    @Override
    public void onGetFeeds() {
        mDatabase.getReference().child("feeds").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<FeedModel> feeds = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    feeds.add(new FeedModel().deserialize(snapshot));
                }

                feedListView.onFeedList(feeds);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
