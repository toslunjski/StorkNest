package hr.foi.air.storknest.app.presenter;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import hr.foi.air.storknest.app.model.DiaperModel;
import hr.foi.air.storknest.app.model.HygieneModel;
import hr.foi.air.storknest.app.view.IDiaperListView;
import hr.foi.air.storknest.app.view.IHygieneListView;

public class HygieneListPresenter implements IHygieneListPresenter {

    private FirebaseDatabase mDatabase;
    private IHygieneListView hygieneListView;

    public HygieneListPresenter(IHygieneListView hygieneListView) {
        this.mDatabase = FirebaseDatabase.getInstance();
        this.hygieneListView = hygieneListView;
    }

    @Override
    public void onGetHygiene() {
        mDatabase.getReference().child("hygiene").addListenerForSingleValueEvent(new ValueEventListener() {
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
