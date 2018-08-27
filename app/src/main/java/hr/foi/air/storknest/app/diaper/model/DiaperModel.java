package hr.foi.air.storknest.app.diaper.model;

import com.google.firebase.database.DataSnapshot;

public class DiaperModel {

    public String id;

    public String user;

    public String diaperPee;

    public String diaperPoo;

    public String createdAt;

    public DiaperModel() {

    }

    public DiaperModel deserialize(DataSnapshot snapshot) {
        id = snapshot.child("id").getValue().toString();
        diaperPee = snapshot.child("diaperPee").getValue().toString();
        diaperPoo = snapshot.child("diaperPoo").getValue().toString();
        createdAt = snapshot.child("createdAt").getValue().toString();

        return this;
    }
}
