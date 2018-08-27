package hr.foi.air.storknest.app.diaper.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.CheckBox;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import hr.foi.air.storknest.app.diaper.model.DiaperModel;
import hr.foi.air.storknest.app.diaper.view.INewDiaperView;


public class NewDiaperPresenter implements INewDiaperPresenter {

    private FirebaseDatabase mDatabase;
    private INewDiaperView newDiaperView;


    public NewDiaperPresenter(INewDiaperView newDiaperView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.newDiaperView = newDiaperView;
    }

    @Override
    public void onSaveDiaper(String user, CheckBox checkPeeValue, CheckBox checkPooValue ) {
        DatabaseReference diapersTable = mDatabase.getReference("diapers/"+user);
        String newDiaperId = diapersTable.push().getKey();

        DiaperModel newDiaper = new DiaperModel();
        newDiaper.id = newDiaperId;
        newDiaper.user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        if(checkPeeValue.isChecked()){
        newDiaper.diaperPee = checkPeeValue.getText().toString();}
        else newDiaper.diaperPee = "";
        if(checkPooValue.isChecked()){
        newDiaper.diaperPoo = checkPooValue.getText().toString();}
        else newDiaper.diaperPoo = "";
        newDiaper.createdAt = new Date().toString();

        diapersTable.child(newDiaperId).setValue(newDiaper).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i("tomo", "diaper saved");
                newDiaperView.onDiaperSaved();
            }
        });
    }
}
