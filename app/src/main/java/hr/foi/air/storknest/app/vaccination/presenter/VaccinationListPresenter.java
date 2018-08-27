package hr.foi.air.storknest.app.vaccination.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hr.foi.air.storknest.app.vaccination.model.VaccinationModel;
import hr.foi.air.storknest.app.vaccination.view.IVaccinationListView;

public class VaccinationListPresenter implements IVaccinationListPresenter {

    private FirebaseDatabase mDatabase;
    private IVaccinationListView vaccinationListView;
    private String user;

    public VaccinationListPresenter(IVaccinationListView vaccinationListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.vaccinationListView = vaccinationListView;
    }

    @Override
    public void onGetVaccination() {
        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase.getReference("vaccination/" + user).addListenerForSingleValueEvent(new ValueEventListener() {
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
