package hr.foi.air.storknest.app.doctor.view;

import java.util.ArrayList;

import hr.foi.air.storknest.app.doctor.model.DoctorModel;

public interface IDoctorListView {
    void onDoctorList(ArrayList<DoctorModel> doctor);
}
