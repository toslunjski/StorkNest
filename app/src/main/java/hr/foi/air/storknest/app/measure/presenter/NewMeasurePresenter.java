package hr.foi.air.storknest.app.measure.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import hr.foi.air.storknest.app.measure.model.MeasureModel;
import hr.foi.air.storknest.app.measure.view.INewMeasureView;


public class NewMeasurePresenter implements INewMeasurePresenter {

    private FirebaseDatabase mDatabase;
    private INewMeasureView newMeasureView;

    public NewMeasurePresenter(INewMeasureView newMeasureView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.newMeasureView = newMeasureView;
    }

    @Override
    public void onSaveMeasure(String user, String weight, String height ) {
        DatabaseReference measureTable = mDatabase.getReference("measure/" + user);
        String newMeasureId = measureTable.push().getKey();

        MeasureModel newMeasure = new MeasureModel();
        newMeasure.id = newMeasureId;
        newMeasure.user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        newMeasure.measureWeight = weight;
        newMeasure.measureHeight = height;



        newMeasure.createdAt = new Date().toString();

        measureTable.child(newMeasureId).setValue(newMeasure).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i("tomo", "measure saved");
                newMeasureView.onMeasureSaved();
            }
        });
    }
}
