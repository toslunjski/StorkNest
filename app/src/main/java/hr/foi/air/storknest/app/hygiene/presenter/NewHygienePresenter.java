package hr.foi.air.storknest.app.hygiene.presenter;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.CheckBox;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

import hr.foi.air.storknest.app.hygiene.model.HygieneModel;
import hr.foi.air.storknest.app.hygiene.view.INewHygieneView;


public class NewHygienePresenter implements INewHygienePresenter {

    private FirebaseDatabase mDatabase;
    private INewHygieneView newHygieneView;

    public NewHygienePresenter(INewHygieneView newHygieneView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.newHygieneView = newHygieneView;
    }

    @Override
    public void onSaveHygiene(String user, CheckBox checkBody, CheckBox checkHair, CheckBox checkBelly ) {
        DatabaseReference hygieneTable = mDatabase.getReference("hygiene/" + user);
        String newHygieneId = hygieneTable.push().getKey();


        HygieneModel newHygiene = new HygieneModel();
        newHygiene.id = newHygieneId;
        newHygiene.user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        if(checkBody.isChecked()){
        newHygiene.hygieneBody = checkBody.getText().toString();}
        else newHygiene.hygieneBody = "";
        if(checkHair.isChecked()){
        newHygiene.hygieneHair = checkHair.getText().toString();}
        else newHygiene.hygieneHair = "";
        if(checkBelly.isChecked()){
            newHygiene.hygieneBelly = checkBelly.getText().toString();}
        else newHygiene.hygieneBelly = "";

        newHygiene.createdAt = new Date().toString();

        hygieneTable.child(newHygieneId).setValue(newHygiene).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                e.printStackTrace();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.i("tomo", "hygiene saved");
                newHygieneView.onHygieneSaved();
            }
        });
    }
}
