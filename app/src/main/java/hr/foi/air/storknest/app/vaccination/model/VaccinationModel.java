package hr.foi.air.storknest.app.vaccination.model;

import com.google.firebase.database.DataSnapshot;

public class VaccinationModel {

    public String id;

    public String vaccinationName;

    public String createdAt;

    public VaccinationModel() {

    }

    public VaccinationModel deserialize(DataSnapshot snapshot) {
        id = snapshot.child("id").getValue().toString();
        vaccinationName = snapshot.child("vaccinationName").getValue().toString();
        createdAt = snapshot.child("createdAt").getValue().toString();

        return this;
    }
}
