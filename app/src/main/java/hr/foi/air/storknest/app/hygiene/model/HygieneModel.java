package hr.foi.air.storknest.app.hygiene.model;

import com.google.firebase.database.DataSnapshot;

public class HygieneModel {

    public String id;

    public String user;

    public String hygieneBody;

    public String hygieneHair;

    public String hygieneBelly;

    public String createdAt;

    public HygieneModel() {

    }

    public HygieneModel deserialize(DataSnapshot snapshot) {
        id = snapshot.child("id").getValue().toString();
        hygieneBody = snapshot.child("hygieneBody").getValue().toString();
        hygieneHair = snapshot.child("hygieneHair").getValue().toString();
        hygieneBelly = snapshot.child("hygieneBelly").getValue().toString();
        createdAt = snapshot.child("createdAt").getValue().toString();

        return this;
    }
}
