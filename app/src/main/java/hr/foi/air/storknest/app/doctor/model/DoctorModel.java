package hr.foi.air.storknest.app.doctor.model;

import com.google.firebase.database.DataSnapshot;

public class DoctorModel {

    public String id;

    public String user;

    public String doctorNameSurname;

    public String doctorType;

    public String doctorWorkingHoursFrom;

    public String doctorWorkingHoursTo;

    public String doctorTelephone;

    public String createdAt;

    public DoctorModel() {

    }

    public DoctorModel deserialize(DataSnapshot snapshot) {
        id = snapshot.child("id").getValue().toString();
        doctorNameSurname = snapshot.child("doctorNameSurname").getValue().toString();
        doctorType = snapshot.child("doctorType").getValue().toString();
        doctorWorkingHoursFrom = snapshot.child("doctorWorkingHoursFrom").getValue().toString();
        doctorWorkingHoursTo = snapshot.child("doctorWorkingHoursTo").getValue().toString();
        doctorTelephone = snapshot.child("doctorTelephone").getValue().toString();
        createdAt = snapshot.child("createdAt").getValue().toString();

        return this;
    }
}
