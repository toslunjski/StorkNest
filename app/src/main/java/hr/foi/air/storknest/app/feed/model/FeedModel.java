package hr.foi.air.storknest.app.feed.model;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;

public class FeedModel {

    public String id;

    public String user;

    public String feedType;

    public String feedAmount;

    public String createdAt;

    public FeedModel() {

    }

    public FeedModel deserialize(DataSnapshot snapshot) {
        id = snapshot.child("id").getValue().toString();
        feedType = snapshot.child("feedType").getValue().toString();
        feedAmount = snapshot.child("feedAmount").getValue().toString();
        createdAt = snapshot.child("createdAt").getValue().toString();

        return this;
    }
}
