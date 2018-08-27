package hr.foi.air.storknest.app.doctor.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hr.foi.air.storknest.app.doctor.model.DoctorModel;
import hr.foi.air.storknest.app.doctor.view.IDoctorListView;
import hr.foi.air.storknest.app.measure.model.MeasureModel;
import hr.foi.air.storknest.app.measure.presenter.IMeasureListPresenter;
import hr.foi.air.storknest.app.measure.view.IMeasureListView;

public class DoctorListPresenter implements IDoctorListPresenter {

    private FirebaseDatabase mDatabase;
    private IDoctorListView doctorListView;

    public DoctorListPresenter(IDoctorListView doctorListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.doctorListView = doctorListView;
    }

    @Override
    public void onGetDoctor() {
        mDatabase.getReference().child("doctor").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<DoctorModel> doctor = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    doctor.add(new DoctorModel().deserialize(snapshot));
                }

                doctorListView.onDoctorList(doctor);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
