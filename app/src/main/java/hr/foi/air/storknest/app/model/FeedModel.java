package hr.foi.air.storknest.app.model;

import com.google.firebase.database.DataSnapshot;

import java.util.Date;

public class FeedModel {

    public String id;

    public String feedType;

    public String createdAt;

    public FeedModel() {

    }

    public FeedModel deserialize(DataSnapshot snapshot) {
        id = snapshot.child("id").getValue().toString();
        feedType = snapshot.child("feedType").getValue().toString();
        createdAt = snapshot.child("createdAt").getValue().toString();

        return this;
    }
}
