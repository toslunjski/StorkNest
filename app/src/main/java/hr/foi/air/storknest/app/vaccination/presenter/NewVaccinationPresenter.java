package hr.foi.air.storknest.app.vaccination.presenter;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import hr.foi.air.storknest.app.vaccination.model.VaccinationModel;
import hr.foi.air.storknest.app.vaccination.view.INewVaccinationView;


public class NewVaccinationPresenter implements INewVaccinationPresenter {

    private FirebaseDatabase mDatabase;
    private INewVaccinationView newVaccinationView;

    public NewVaccinationPresenter(INewVaccinationView newVaccinationView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.newVaccinationView = newVaccinationView;
    }

    @Override
    public void onSaveVaccination(String user, String vaccinationName) {
        DatabaseReference vaccinationTable = mDatabase.getReference("vaccination/" + user);
        String newVaccinationId = vaccinationTable.push().getKey();

        VaccinationModel newVaccination = new VaccinationModel();
        newVaccination.id = newVaccinationId;
        newVaccination.user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        newVaccination.vaccinationName = vaccinationName;
        newVaccination.createdAt = new Date().toString();

        vaccinationTable.child(newVaccinationId).setValue(newVaccination).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i("tomo", "Vaccination saved");
                newVaccinationView.onVaccinationSaved();
            }
        });
    }
}
