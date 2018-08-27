package hr.foi.air.storknest.app.doctor.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hr.foi.air.storknest.app.doctor.model.DoctorModel;
import hr.foi.air.storknest.app.doctor.view.IDoctorListView;

public class DoctorListPresenter implements IDoctorListPresenter {

    private FirebaseDatabase mDatabase;
    private IDoctorListView doctorListView;
    private String user;

    public DoctorListPresenter(IDoctorListView doctorListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.doctorListView = doctorListView;
    }

    @Override
    public void onGetDoctor() {
        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase.getReference("doctor/" + user).addListenerForSingleValueEvent(new ValueEventListener() {
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
