package hr.foi.air.storknest.app.hygiene.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hr.foi.air.storknest.app.hygiene.model.HygieneModel;
import hr.foi.air.storknest.app.hygiene.view.IHygieneListView;

public class HygieneListPresenter implements IHygieneListPresenter {

    private FirebaseDatabase mDatabase;
    private IHygieneListView hygieneListView;
    private String user;

    public HygieneListPresenter(IHygieneListView hygieneListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.hygieneListView = hygieneListView;
    }

    @Override
    public void onGetHygiene() {
        user = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase.getReference("hygiene/" + user).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ArrayList<HygieneModel> hygiene = new ArrayList<>();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    hygiene.add(new HygieneModel().deserialize(snapshot));
                }

                hygieneListView.onHygieneList(hygiene);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
