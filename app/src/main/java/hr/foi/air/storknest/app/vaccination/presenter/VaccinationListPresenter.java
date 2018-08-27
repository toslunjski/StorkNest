package hr.foi.air.storknest.app.vaccination.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hr.foi.air.storknest.app.doctor.model.DoctorModel;
import hr.foi.air.storknest.app.doctor.presenter.IDoctorListPresenter;
import hr.foi.air.storknest.app.doctor.view.IDoctorListView;
import hr.foi.air.storknest.app.vaccination.model.VaccinationModel;
import hr.foi.air.storknest.app.vaccination.view.IVaccinationListView;

public class VaccinationListPresenter implements IVaccinationListPresenter {

    private FirebaseDatabase mDatabase;
    private IVaccinationListView vaccinationListView;

    public VaccinationListPresenter(IVaccinationListView vaccinationListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.vaccinationListView = vaccinationListView;
    }

    @Override
    public void onGetVaccination() {
        mDatabase.getReference().child("vaccination").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<VaccinationModel> vaccination = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    vaccination.add(new VaccinationModel().deserialize(snapshot));
                }

                vaccinationListView.onVaccinationList(vaccination);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
