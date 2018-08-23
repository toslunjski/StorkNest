package hr.foi.air.storknest.app.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.RadioButton;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

import hr.foi.air.storknest.app.model.FeedModel;
import hr.foi.air.storknest.app.view.INewFeedView;

public class NewFeedPresenter implements INewFeedPresenter {

    private FirebaseDatabase mDatabase;
    private INewFeedView newFeedView;

    public NewFeedPresenter(INewFeedView newFeedView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.newFeedView = newFeedView;
    }

    @Override
    public void onSaveFeed(RadioButton selectedFeedType) {
        DatabaseReference feedsTable = mDatabase.getReference("feeds");
        String newFeedId = feedsTable.push().getKey();

        FeedModel newFeed = new FeedModel();
        newFeed.id = newFeedId;
        newFeed.feedType = selectedFeedType.getText().toString();
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
