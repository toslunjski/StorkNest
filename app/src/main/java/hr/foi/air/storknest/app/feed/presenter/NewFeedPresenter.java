package hr.foi.air.storknest.app.feed.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.RadioButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import hr.foi.air.storknest.app.feed.model.FeedModel;
import hr.foi.air.storknest.app.feed.view.INewFeedView;

public class NewFeedPresenter implements INewFeedPresenter {

    private FirebaseDatabase mDatabase;
    private INewFeedView newFeedView;

    public NewFeedPresenter(INewFeedView newFeedView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.newFeedView = newFeedView;
    }

    @Override
    public void onSaveFeed(String user, RadioButton selectedFeedType, RadioButton selectedFeedAmount ) {
        DatabaseReference feedsTable = mDatabase.getReference("feeds/" + user); //getReference("feeds" )
        String newFeedId = feedsTable.push().getKey();

        FeedModel newFeed = new FeedModel();
        newFeed.id = newFeedId;
        newFeed.user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        newFeed.feedType = selectedFeedType.getText().toString();
        newFeed.feedAmount = selectedFeedAmount.getText().toString();
        newFeed.createdAt = new Date().toString();

        feedsTable.child(newFeedId).setValue(newFeed).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i("tomo", "feed saved");
                newFeedView.onFeedSaved();
            }
        });
    }
}
