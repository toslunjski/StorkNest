package hr.foi.air.storknest.app.doctor.presenter;


import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import hr.foi.air.storknest.app.doctor.model.DoctorModel;
import hr.foi.air.storknest.app.doctor.view.INewDoctorView;



public class NewDoctorPresenter implements INewDoctorPresenter {

    private FirebaseDatabase mDatabase;
    private INewDoctorView newDoctorView;

    public NewDoctorPresenter(INewDoctorView newDoctorView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.newDoctorView = newDoctorView;
    }

    @Override
    public void onSaveDoctor(String user, String nameSurname, String type, String workingHoursFrom, String workingHoursTo, String telephone ) {
        DatabaseReference doctorTable = mDatabase.getReference("doctor/"+ user);
        String newDoctorId = doctorTable.push().getKey();

        DoctorModel newDoctor = new DoctorModel();
        newDoctor.id = newDoctorId;
        newDoctor.user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        newDoctor.doctorNameSurname = nameSurname;
        newDoctor.doctorType = type;
        newDoctor.doctorWorkingHoursFrom = workingHoursFrom;
        newDoctor.doctorWorkingHoursTo = workingHoursTo;
        newDoctor.doctorTelephone = telephone;




        newDoctor.createdAt = new Date().toString();

        doctorTable.child(newDoctorId).setValue(newDoctor).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i("tomo", "doctor saved");
                newDoctorView.onDoctorSaved();
            }
        });
    }
}
