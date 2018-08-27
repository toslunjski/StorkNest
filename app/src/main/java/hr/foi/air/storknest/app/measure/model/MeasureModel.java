package hr.foi.air.storknest.app.measure.model;

import com.google.firebase.database.DataSnapshot;

public class MeasureModel {

    public String id;

    public String user;

    public String measureWeight;

    public String measureHeight;

    public String createdAt;

    public MeasureModel() {

    }

    public MeasureModel deserialize(DataSnapshot snapshot) {
        id = snapshot.child("id").getValue().toString();
        measureWeight = snapshot.child("measureWeight").getValue().toString();
        measureHeight = snapshot.child("measureHeight").getValue().toString();
        createdAt = snapshot.child("createdAt").getValue().toString();

        return this;
    }
}
